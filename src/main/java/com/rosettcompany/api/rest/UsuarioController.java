package com.rosettcompany.api.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rosettcompany.api.entity.RossetRequestEmail;
import com.rosettcompany.api.entity.Usuario;
import com.rosettcompany.api.error.classes.ResponseDetail;
import com.rosettcompany.api.error.constant.CodeDeveloper;
import com.rosettcompany.api.error.exceptions.ResourceNotFoundException;
import com.rosettcompany.api.error.exceptions.ServerErrorException;
import com.rosettcompany.api.service.UsuarioService;

@RestController
@RequestMapping("/api/v1")

public class UsuarioController {

	@Autowired
	private UsuarioService service;
	
	@GetMapping
	public ResponseEntity<?> saludar() {
		return new ResponseEntity<>("API de Rosett Company", HttpStatus.OK);
	}
	
	@GetMapping("/usuarios")
	public ResponseEntity<List<Usuario>> getUsuarios() {
		List<Usuario> usuarios = service.findAll();
		if (usuarios.isEmpty()) {
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<>(usuarios, HttpStatus.OK);
	}

	@GetMapping("/usuarios/{id}")
	public ResponseEntity<Usuario> getUsuarioById(@PathVariable long id) {
		return new ResponseEntity<>(service.findById(id), HttpStatus.OK);
	}

	@PostMapping(value = { "/usuarios", "/register","loginfb"})
	public ResponseEntity<?> create(@RequestBody Usuario usuario) {
		int result = service.save(usuario);
		if (result == -1) {
			throw new ResourceNotFoundException("Este email ya se encuentra registrado",
					CodeDeveloper.USER_ALREADY_REGISTERED);
		}
		
		return ResponseDetail.CREATED("Usuario creado correctamente",service.findById(result));
	}

	@PostMapping("/login")
	public ResponseEntity<?> login(@RequestBody RossetRequestEmail request) {

		int result = service.login(request);
		if (result != 1) {
			if (result == 0) {
				throw new ResourceNotFoundException(
						"No existe una cuenta asociada al email " + request.getEmail() + ".",
						CodeDeveloper.USER_NOT_REGISTERED);
			} else if (result == -1) {
				throw new ResourceNotFoundException("Password incorrecto.", CodeDeveloper.PASSWORD_INCORRECT);
			} else {
				throw new ServerErrorException("Ha ocurrido un error en el servidor.");
			}

		}
		
		return ResponseDetail.OK("Credenciales correctas.", service.findUserByEmail(request.getEmail()));
	}

}

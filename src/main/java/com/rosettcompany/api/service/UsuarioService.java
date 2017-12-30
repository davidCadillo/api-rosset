package com.rosettcompany.api.service;

import java.sql.Timestamp;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rosettcompany.api.entity.Usuario;
import com.rosettcompany.api.repository.UsuarioRepository;

@Service
public class UsuarioService implements IUsuarioService {

	@Autowired
	private UsuarioRepository repository;

	@Override
	public List<Usuario> findAll() {
		return repository.findAll();
	}

	@Override
	public Integer save(Usuario usuario) {
		return repository.registrar(usuario.getId_redsocial(), usuario.getEmail(), usuario.getUrl_redsocial(),
				usuario.getNombres(), usuario.getApellidos(), usuario.getSexo(), usuario.getContrasena(),
				usuario.getFec_nacimiento(), usuario.getCod_ubigeo(), new Timestamp(System.currentTimeMillis()),
				usuario.getNom_colegio(), usuario.getRuta_foto_img(), usuario.getInd_red_social());
	}

	@Override
	public Usuario findById(long id) {
		return repository.findOne(id);
	}

	@Override
	public Usuario findUserByEmail(String email) {
		return repository.findByEmail(email);
	}

	@Override
	public Integer login(Usuario usuario) {
		return repository.validar_correo_y_pass(usuario.getEmail(), usuario.getContrasena());
	}

}

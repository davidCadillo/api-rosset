package com.rosettcompany.api.entity;

import java.text.DateFormat;
import java.text.SimpleDateFormat;

import lombok.Data;

@Data
public class UsuarioResponse {
	
	private String nombres;
	private String apellidos;
	private int sexo;
	private String fechaNacimieto;
	private String ubigeo;
	private String fechaRegistro;
	private String colegio;
	private String urlAvatar;
	
	
	public UsuarioResponse(Usuario usuario) {
		
		this.nombres = usuario.getNombres();
		this.apellidos = usuario.getApellidos();
		this.sexo = usuario.getSexo().equalsIgnoreCase("female") ? 0 : 1;
		this.fechaNacimieto = usuario.getFec_nacimiento();
		this.ubigeo = usuario.getCod_ubigeo();
		DateFormat df = new SimpleDateFormat("MM/dd/yyyy");
		this.fechaRegistro = df.format(usuario.getFec_registro());
		this.colegio = usuario.getNom_colegio();
		this.urlAvatar = usuario.getRuta_foto_img();
		
	}
	
	
	
	
	
}

package com.rosettcompany.api.entity;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;

@Entity
@Table(name = "t0010usuario")
@Data

public class Usuario {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_usuario")
	@SequenceGenerator(sequenceName = "serie_idusuario", allocationSize = 1, name = "seq_usuario")
	@Column(name = "idusuario")
	private long id;

	private int codigo_cliente = 1;

	private int idsede = 1;

	private int idseccion = 1;

	private String id_redsocial = "";

	private String cod_estudiante = "";

	private String email = "";

	@JsonIgnore
	private String url_redsocial = "";

	private String nombres = "";
	
	private String apellidos = "";

	private String sexo = "";

	@JsonIgnore
	private String contrasena = "";

	private String fec_nacimiento = "";

	private String cod_ubigeo = "";

	private Date fec_registro;

	private String nom_colegio = "";

	private String ruta_foto_img = "";

	private int ind_red_social;

	private int visible_rank = 1;

	private int grado = 6;

	private int ind_concurso = 0;

	private int ind_alta = 1;

	public Usuario() {

	}


	public Usuario(String id_redsocial, String email, String url_redsocial, String nombres, String apellidos,
			String sexo, String contrasena, String fec_nacimiento, String cod_ubigeo, String nom_colegio,
			String ruta_foto_img, int ind_red_social) {
		this.id_redsocial = id_redsocial;
		this.email = email;
		this.url_redsocial = url_redsocial;
		this.nombres = nombres;
		this.apellidos = apellidos;
		this.sexo = sexo;
		this.contrasena = contrasena;
		this.fec_nacimiento = fec_nacimiento;
		this.cod_ubigeo = cod_ubigeo;
		this.nom_colegio = nom_colegio;
		this.ruta_foto_img = ruta_foto_img;
		this.ind_red_social = ind_red_social;
	}
	
	

}

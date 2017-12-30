package com.rosettcompany.api.service;

import java.util.List;

import com.rosettcompany.api.entity.Usuario;

public interface IUsuarioService {

	public List<Usuario> findAll();
	public Integer save(Usuario usuario);
	
	public Integer login(Usuario usuario);
	
	public Usuario findById(long id);
	
	public Usuario findUserByEmail(String email);

}

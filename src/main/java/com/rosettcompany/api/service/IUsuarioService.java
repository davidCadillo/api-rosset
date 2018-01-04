package com.rosettcompany.api.service;

import java.util.List;

import com.rosettcompany.api.entity.RossetRequestEmail;
import com.rosettcompany.api.entity.Usuario;
import com.rosettcompany.api.entity.UsuarioResponse;

public interface IUsuarioService {

	public List<UsuarioResponse> findAll();
	public Integer save(Usuario usuario);
	
	public Integer login(RossetRequestEmail usuario);
	
	public UsuarioResponse findById(long id);
	
	public UsuarioResponse findUserByEmail(String email);

}

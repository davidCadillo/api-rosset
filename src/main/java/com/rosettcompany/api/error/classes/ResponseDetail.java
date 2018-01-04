package com.rosettcompany.api.error.classes;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.rosettcompany.api.entity.UsuarioResponse;
import com.rosettcompany.api.error.constant.HttpStatusMessage;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = false)
public class ResponseDetail extends Detail {

	private UsuarioResponse usuario;
	
	public static  ResponseEntity<?> OK(String detail, UsuarioResponse usuario) {
		ResponseDetail r = new ResponseDetail();
		r.status =200;
		r.title = HttpStatusMessage.OK;
		r.detail = detail;
		r.usuario = usuario;
		return new ResponseEntity<>(r, HttpStatus.OK);
		
	}
	
	public static  ResponseEntity<?> CREATED(String detail, UsuarioResponse usuario) {
		ResponseDetail r = new ResponseDetail();
		r.status =201;
		r.title = HttpStatusMessage.CREATED;
		r.detail = detail;
		r.usuario = usuario;
		return new ResponseEntity<>(r, HttpStatus.CREATED);
		
	}

}

package com.rosettcompany.api.error.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.rosettcompany.api.error.constant.HttpStatusMessage;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class ResourceNotFoundException extends RossetException {

	private static final long serialVersionUID = 1L;
	
	public ResourceNotFoundException() {
		
	}

	public ResourceNotFoundException(String message, Throwable cause) {
		super(message, cause);
	}

	public ResourceNotFoundException(String message) {
		super(message);
	}
	

	public ResourceNotFoundException(String message, int codeDeveloper) {
		super(message, codeDeveloper);
	}

	@Override
	public HttpStatus getStatusCode() {
		return HttpStatus.NOT_FOUND;
	}

	@Override
	public String getTitle() {
		return HttpStatusMessage.NOT_FOUND;
	}

	
	
	
}

package com.rosettcompany.api.error.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.rosettcompany.api.error.constant.HttpStatusMessage;

@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
public class ServerErrorException extends RossetException {


	private static final long serialVersionUID = 1L;

	public ServerErrorException() {
	}

	public ServerErrorException(String message, Throwable cause) {
		super(message, cause);
	}

	public ServerErrorException(String message) {
		super(message);
	}
	
	

	public ServerErrorException(String message, int codeDeveloper) {
		super(message, codeDeveloper);
	}

	@Override
	public HttpStatus getStatusCode() {
		return HttpStatus.INTERNAL_SERVER_ERROR;
	}

	@Override
	public String getTitle() {
		return HttpStatusMessage.INTERNAL_SERVER_ERROR;
	}
	
	
	

}

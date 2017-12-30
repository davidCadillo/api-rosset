package com.rosettcompany.api.error.exceptions;

import org.springframework.http.HttpStatus;



public abstract class RossetException extends RuntimeException {
	
	private static final long serialVersionUID = 1L;
	private int codeDeveloper;

	public RossetException() {
	}

	public RossetException(String message, Throwable cause) {
		super(message, cause);
	}

	public RossetException(String message) {
		super(message);
	}
	
	public RossetException(String message, int codeDeveloper) {
		super(message);
		this.codeDeveloper = codeDeveloper;
	}
	
	public abstract HttpStatus getStatusCode();
	
	public abstract String getTitle();

	public int getCodeDeveloper() {
		return codeDeveloper;
	}

	public void setCodeDeveloper(int codeDeveloper) {
		this.codeDeveloper = codeDeveloper;
	}
	
	

}

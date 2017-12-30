package com.rosettcompany.api.error;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.rosettcompany.api.error.classes.ErrorDetail;
import com.rosettcompany.api.error.exceptions.RossetException;

@ControllerAdvice
public class RestExceptionHandler {
	
	@ExceptionHandler(RossetException.class)
	public ResponseEntity<?> handleException(RossetException rex, HttpServletRequest request){
		
		ErrorDetail errorDetail = new ErrorDetail();
		errorDetail.setTimeStamp(System.currentTimeMillis());
		errorDetail.setStatus(rex.getStatusCode().value());
		errorDetail.setTitle(rex.getTitle());
		errorDetail.setDetail(rex.getMessage());
		errorDetail.setCodeDeveloper(rex.getCodeDeveloper());
		return new ResponseEntity<>(errorDetail, null, rex.getStatusCode());
		
		
	}

}

package com.projetocalculadora.softexpert.exceptions;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import jakarta.servlet.http.HttpServletRequest;


@ControllerAdvice
public class ResourceExceptionHandler {
	
	@ExceptionHandler(Exception.class)
	public ResponseEntity<StandardError> objectNotFound(Exception e, HttpServletRequest request) {
		
		StandardError err = new StandardError(System.currentTimeMillis(), HttpStatus.BAD_REQUEST.value(), "Ocorreu um erro interno", e.getMessage(), request.getRequestURI());
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(err);
	}

}

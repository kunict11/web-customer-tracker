package com.tanja.web_customer_tracker.rest.developer;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;


@ControllerAdvice
public class DeveloperRestExceptionHandler {

	@ExceptionHandler
	public ResponseEntity<DeveloperErrorResponse> handleCustomerNotFoundException(DeveloperNotFoundException ex) {
		
		DeveloperErrorResponse developerError = new DeveloperErrorResponse();
		
		developerError.setMessage(ex.getMessage());
		developerError.setStatus(HttpStatus.NOT_FOUND.value());
		developerError.setTimestamp(System.currentTimeMillis());
		
		return new ResponseEntity<>(developerError, HttpStatus.NOT_FOUND);
	}
	
}

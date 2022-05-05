package com.tanja.web_customer_tracker.rest.customer;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class CustomerRestExceptionHandler {

	@ExceptionHandler
	public ResponseEntity<CustomerErrorResponse> handleCustomerNotFoundException(CustomerNotFoundException ex) {
		
		CustomerErrorResponse customerError = new CustomerErrorResponse();
		
		customerError.setMessage(ex.getMessage());
		customerError.setStatus(HttpStatus.NOT_FOUND.value());
		customerError.setTimestamp(System.currentTimeMillis());
		
		return new ResponseEntity<>(customerError, HttpStatus.NOT_FOUND);
	}

}

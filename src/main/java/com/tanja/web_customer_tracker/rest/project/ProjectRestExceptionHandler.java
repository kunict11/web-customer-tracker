package com.tanja.web_customer_tracker.rest.project;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ProjectRestExceptionHandler {

	@ExceptionHandler
	public ResponseEntity<ProjectErrorResponse> handleProjectNotFoundError(ProjectNotFoundException ex) {
		
		ProjectErrorResponse res = new ProjectErrorResponse();
		
		res.setMessage(ex.getMessage());
		res.setStatus(HttpStatus.NOT_FOUND.value());
		res.setTimestamp(System.currentTimeMillis());
		
		return new ResponseEntity<>(res, HttpStatus.NOT_FOUND);
	}
	
}

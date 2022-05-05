package com.tanja.web_customer_tracker.rest.project;

public class ProjectNotFoundException extends RuntimeException {

	public ProjectNotFoundException(String message) {
		super(message);
	}

	public ProjectNotFoundException(Throwable cause) {
		super(cause);
	}

	public ProjectNotFoundException(String message, Throwable cause) {
		super(message, cause);
	}

}

package com.tanja.web_customer_tracker.rest.developer;

public class DeveloperNotFoundException extends RuntimeException {

	public DeveloperNotFoundException(String message) {
		super(message);
	}

	public DeveloperNotFoundException(Throwable cause) {
		super(cause);
	}

	public DeveloperNotFoundException(String message, Throwable cause) {
		super(message, cause);
	}

}

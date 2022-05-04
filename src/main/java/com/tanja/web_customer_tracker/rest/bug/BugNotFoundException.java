package com.tanja.web_customer_tracker.rest.bug;

public class BugNotFoundException extends RuntimeException {

	public BugNotFoundException() {
	}

	public BugNotFoundException(String message) {
		super(message);
	}

	public BugNotFoundException(Throwable cause) {
		super(cause);
	}

	public BugNotFoundException(String message, Throwable cause) {
		super(message, cause);
	}

}

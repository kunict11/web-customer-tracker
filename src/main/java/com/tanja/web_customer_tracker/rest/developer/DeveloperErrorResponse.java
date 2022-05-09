package com.tanja.web_customer_tracker.rest.developer;

public class DeveloperErrorResponse {

	private String message;
	private int status;
	private long timestamp;
	
	public DeveloperErrorResponse() {
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public long getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(long timestamp) {
		this.timestamp = timestamp;
	}
	
	
}

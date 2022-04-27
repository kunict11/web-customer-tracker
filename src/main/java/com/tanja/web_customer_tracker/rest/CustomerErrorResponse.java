package com.tanja.web_customer_tracker.rest;

public class CustomerErrorResponse {

	private int status;
	private String message;
	private long timestamp;
	
	public CustomerErrorResponse() { }

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public long getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(long timestamp) {
		this.timestamp = timestamp;
	}
		

}
package com.tanja.web_customer_tracker.rest.project;

public class ProjectErrorResponse {
	
	private String message;
	
	private int status;
	
	private long timestamp;

	public ProjectErrorResponse() {
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

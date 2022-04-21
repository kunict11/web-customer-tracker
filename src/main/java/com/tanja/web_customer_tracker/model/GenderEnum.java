package com.tanja.web_customer_tracker.model;

public enum GenderEnum {
	MALE("m"),
	FEMALE("f"),
	OTHER("n/a");
	
	private String name;

	private GenderEnum(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}
	
	
	
}

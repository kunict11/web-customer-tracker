package com.tanja.web_customer_tracker.model.project;

public class ProjectDto {

	private int id;
	private String name;
	private String component;
	
	public ProjectDto(int id, String name, String component) {
		this.id = id;
		this.name = name;
		this.component = component;
	}
	public ProjectDto() {
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getComponent() {
		return component;
	}
	public void setComponent(String component) {
		this.component = component;
	}

}

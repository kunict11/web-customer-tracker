package com.tanja.web_customer_tracker.service;

import java.util.List;

import com.tanja.web_customer_tracker.model.Project;

public interface ProjectService {

	public List<Project> getAllProjects();
	
	public Project getProjectById(int id);
	
	public void saveProject(Project project);
	
	public void deleteProject(int id);
	
}

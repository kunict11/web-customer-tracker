package com.tanja.web_customer_tracker.service.project;

import java.util.List;

import com.tanja.web_customer_tracker.model.project.Project;

public interface ProjectService {

	public List<Project> getAllProjects();
	
	public Project getProjectById(int id);
	
	public void saveProject(Project project);
	
	public void deleteProject(int id);
	
	public List<Project> getAllProjectsWithBugs();
}

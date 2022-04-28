package com.tanja.web_customer_tracker.DAO.project;

import java.util.List;

import com.tanja.web_customer_tracker.model.project.Project;

public interface ProjectDAO {

	public List<Project> getAllProjects();
	
	public Project getProject(int id);
	
	public void saveProject(Project project);
	
	public void deleteProject(int id);
	
}

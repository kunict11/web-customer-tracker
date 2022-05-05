package com.tanja.web_customer_tracker.rest.project;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tanja.web_customer_tracker.model.project.Project;
import com.tanja.web_customer_tracker.service.project.ProjectService;

@RestController
@CrossOrigin
@RequestMapping("/api")
public class ProjectRestController {

	@Autowired
	private ProjectService projectService;
	
	@GetMapping("/projects")
	public List<Project> getAllProjects() {
		return projectService.getAllProjects();
	}
	
	@GetMapping("/projects/{id}")
	public Project getProjectById(@PathVariable("id") int id) {
		
		Project project = projectService.getProjectById(id);
		
		if (project == null) {
			throw new ProjectNotFoundException("Project with id " + id + " doesn't exist.");
		}
		
		return project;
	}
	
	
}

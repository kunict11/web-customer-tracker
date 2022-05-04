package com.tanja.web_customer_tracker.rest.project;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tanja.web_customer_tracker.model.project.Project;
import com.tanja.web_customer_tracker.model.project.ProjectDto;
import com.tanja.web_customer_tracker.service.project.ProjectService;
import com.tanja.web_customer_tracker.util.DtoMapper;

@RestController
@CrossOrigin
@RequestMapping("/api/projects")
public class ProjectRestController {

	@Autowired
	private ProjectService projectService;
	
	@Autowired
	private DtoMapper mapper;
	
	@GetMapping("/")
	public List<ProjectDto> getAllProjects() {
		return projectService.getAllProjects()
				.stream()
				.map(project -> mapper.toProjectDto(project))
				.collect(Collectors.toList());
	}
	
	@GetMapping("/{id}")
	public ProjectDto getProjectById(@PathVariable("id") int id) {
		
		Project project = projectService.getProjectById(id);
		
		if (project == null) {
			throw new ProjectNotFoundException("Project with id " + id + " doesn't exist.");
		}
		
		return mapper.toProjectDto(project);
	}
	
	
}

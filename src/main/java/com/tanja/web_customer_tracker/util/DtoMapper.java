package com.tanja.web_customer_tracker.util;

import org.springframework.stereotype.Component;

import com.tanja.web_customer_tracker.model.project.Project;
import com.tanja.web_customer_tracker.model.project.ProjectDto;

@Component
public class DtoMapper {

	public DtoMapper() {}
	
	public ProjectDto toProjectDto(Project project) {
		return new ProjectDto(project.getId(), project.getName(), project.getComponent());
	}
}

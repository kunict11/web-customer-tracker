package com.tanja.web_customer_tracker.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.tanja.web_customer_tracker.model.Project;

@Controller
@RequestMapping("/project")
public class ProjectController {

	@RequestMapping("/showForm")
	public String showAddProjectForm(Model model) {
		
		Project project = new Project();
		model.addAttribute("project", project);
		
		return "add-project";
	}
	
}

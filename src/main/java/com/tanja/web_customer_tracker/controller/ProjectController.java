package com.tanja.web_customer_tracker.controller;

import java.util.Base64;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.tanja.web_customer_tracker.model.Customer;
import com.tanja.web_customer_tracker.model.Project;
import com.tanja.web_customer_tracker.service.ProjectService;

@Controller
@RequestMapping("/project")
public class ProjectController {

	@Autowired
	private ProjectService projectService;
	
	@RequestMapping("/showForm")
	public String showAddProjectForm(Model model) {
		
		Project project = new Project();
		model.addAttribute("project", project);
		
		return "add-project";
	}
	
	@RequestMapping("/reportBugForm")
	public String showReportBugForm(Model model) {
		
		List<Project> projects = projectService.getAllProjects();
		
		model.addAttribute("projects", projects);
		
		return "report-bug";
	}
	
	@RequestMapping("/details/{id}")
	public String showCustomerDetails(@PathVariable int id, Model model) {
		
		Project project = projectService.getProjectById(id);
		
		model.addAttribute("project", project);

		
		return "project-details";
	}
}

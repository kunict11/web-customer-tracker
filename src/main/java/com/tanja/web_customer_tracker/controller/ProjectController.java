package com.tanja.web_customer_tracker.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.tanja.web_customer_tracker.model.bug.Bug;
import com.tanja.web_customer_tracker.model.bug.Status;
import com.tanja.web_customer_tracker.model.customer.Customer;
import com.tanja.web_customer_tracker.model.project.Project;
import com.tanja.web_customer_tracker.service.bug.BugService;
import com.tanja.web_customer_tracker.service.customer.CustomerService;
import com.tanja.web_customer_tracker.service.project.ProjectService;

@Controller
@RequestMapping("/project")
public class ProjectController {

	@Autowired
	private ProjectService projectService;
	@Autowired
	private BugService bugService;
	@Autowired
	private CustomerService customerService;
	
	@RequestMapping("/showForm")
	public String showAddProjectForm(Model model) {
		
		Project project = new Project();
		model.addAttribute("project", project);
		
		return "add-project";
	}
	
	@RequestMapping("/reportBugForm")
	public String showReportBugForm(Model model) {
		
		List<Project> projects = projectService.getAllProjects();
		Bug bug = new Bug();
		
		model.addAttribute("projects", projects);
		model.addAttribute("bug", bug);
		
		return "report-bug";
	}
	
	@RequestMapping("/reportBug")
	public String reportBug(@ModelAttribute("bug") Bug bug, @RequestParam("selectedProject") int projectId) {
				
		Project project = projectService.getProjectById(projectId);
		
		bug.setId(0);
		bug.setStatus(Status.UNRESOLVED);
		bug.addProject(project);
		String email = SecurityContextHolder.getContext().getAuthentication().getName();
		Customer customer = customerService.getCustomerByEmail(email);
		
		if (customer == null) {
			return "redirect:/project/reportBugForm";
		}
		customer.reportBug(bug);
		
		bugService.saveBug(bug);
		
		return "redirect:/project/bugList";
	} 
	
	@RequestMapping("/details")
	public String showCustomerDetails(@RequestParam("id") int id, Model model) {
		
		Project project = projectService.getProjectById(id);
		
		model.addAttribute("project", project);

		
		return "project-details";
	}
	
	@RequestMapping("/bugList")
	public String bugList(Model model) {
		
		List<Project> projects = projectService.getAllProjectsWithBugs();

		for (Project project : projects) {
			System.out.println(project.getBugs());
		}
		
		model.addAttribute("projects", projects);
		
		
		return "bug-list";
	}
}

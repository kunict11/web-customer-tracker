package com.tanja.web_customer_tracker.controller;

import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.tanja.web_customer_tracker.model.developer.Developer;
import com.tanja.web_customer_tracker.model.project.Project;
import com.tanja.web_customer_tracker.service.developer.DeveloperService;
import com.tanja.web_customer_tracker.service.project.ProjectService;

@Controller
@RequestMapping("/developer")
public class DeveloperController {
	
	@Autowired
	private DeveloperService developerService;
	
	@Autowired
	private ProjectService projectService;
	
	@RequestMapping("/list")
	public String showDeveloperList(Model model) {
		
		List<Developer> developers = developerService.getAllDevelopers();
		// :(
		Collections.sort(developers, (dev1, dev2) -> {
			if (dev1.getProject() == null && dev2.getProject() == null)
				return dev1.getFirstName().compareTo(dev2.getFirstName());
			if (dev1.getProject() == null)
				return 1;
			if (dev2.getProject() == null)
				return -1;
			return dev1.getProject().getName().compareTo(dev2.getProject().getName()); 
		});
		
		model.addAttribute("developers", developers);
		
		return "developer-list";
	}
	
	@RequestMapping("/showDevForm")
	public String showDevForm(Model model) {
		
		Developer dev = new Developer();
		List<Project> projects = projectService.getAllProjects(); 
		
		model.addAttribute("developer", dev);
		model.addAttribute("projects", projects);
		
		return "add-developer";
	}
	
	@RequestMapping("/saveDeveloper")
	public String saveDeveloper(@ModelAttribute("developer") Developer dev) {
		
		int projectId = dev.getProject().getId();
		
		if (projectId == 0) {
			dev.setProject(null);
		}
		else {
			Project project = projectService.getProjectById(projectId);
			project.addDeveloper(dev);
		}
		
		developerService.saveDeveloper(dev);
		
		return "redirect:/developer/list";
	}

}

package com.tanja.web_customer_tracker.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.tanja.web_customer_tracker.model.bug.Bug;
import com.tanja.web_customer_tracker.model.bug.Status;
import com.tanja.web_customer_tracker.model.developer.Developer;
import com.tanja.web_customer_tracker.model.project.Project;
import com.tanja.web_customer_tracker.service.bug.BugService;
import com.tanja.web_customer_tracker.service.developer.DeveloperService;

@Controller
@RequestMapping("/bug")
public class BugController {
	
	@Autowired
	private BugService bugService;
	
	@Autowired
	private DeveloperService developerService;
	
	@RequestMapping("/bugStatus")
	public String showBugStatus(@RequestParam("bugId") int bugId, Model model) {
		
		Bug bug = bugService.getBugById(bugId);
		model.addAttribute("bug", bug);
		
		return "bug-status";
	}
	
	@RequestMapping("/changeStatus")
	public String changeStatus(@ModelAttribute("bug") Bug bug) {
		
		Bug existingBug = bugService.getBugById(bug.getId());
		existingBug.setStatus(bug.getStatus());
		
		bugService.saveBug(existingBug);
		
		return "redirect:/project/bugList";
	}
	
	@RequestMapping("/details")
	public String showBugDetails(@RequestParam("projectId") int projectId, @RequestParam("bugId") int bugId, Model model) {
		
		Bug bug = bugService.getBugById(bugId);
		
		Project project = bug.getProjects()
				.stream()
				.filter(p -> p.getId() == projectId)
				.findFirst()
				.orElse(null);
		
		model.addAttribute("bug", bug);
		model.addAttribute("project", project);
		
		return "bug-details";
	} 
	
	@RequestMapping("/assignDeveloper")
	public String assignDeveloper(@RequestParam("bugId") int bugId, @RequestParam("devId") int devId) {
		
		Developer dev = developerService.getDeveloperById(devId);
		Bug bug = bugService.getBugById(bugId);
		
		bug.setAssignedDeveloper(dev);
		bug.setStatus(Status.IN_PROGRESS);
		
		bugService.saveBug(bug);

		return "redirect:/project/bugList";
	}
	
	@RequestMapping("/resolveBug")
	public String resolveBug(@RequestParam("bugId") int bugId) {
		
		Bug bug = bugService.getBugById(bugId);
		bug.setStatus(Status.RESOLVED);
		
		bugService.saveBug(bug);
		
		return "redirect:/project/bugList";
	}
}

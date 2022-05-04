package com.tanja.web_customer_tracker.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.tanja.web_customer_tracker.model.bug.Bug;
import com.tanja.web_customer_tracker.service.bug.BugService;

@Controller
@RequestMapping("/bug")
public class BugController {
	
	@Autowired
	private BugService bugService;
	
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
}

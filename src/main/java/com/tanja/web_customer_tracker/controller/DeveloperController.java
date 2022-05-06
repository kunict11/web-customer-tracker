package com.tanja.web_customer_tracker.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.tanja.web_customer_tracker.model.developer.Developer;
import com.tanja.web_customer_tracker.service.developer.DeveloperService;

@Controller
@RequestMapping("/developer")
public class DeveloperController {
	
	@Autowired
	private DeveloperService developerService;
	
	@RequestMapping("/list")
	public String showDeveloperList(Model model) {
		
		List<Developer> developers = developerService.getAllDevelopers();
		
		model.addAttribute("developers", developers);
		
		return "developer-list";
	}

}

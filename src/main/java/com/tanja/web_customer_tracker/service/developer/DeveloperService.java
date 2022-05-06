package com.tanja.web_customer_tracker.service.developer;

import java.util.List;

import com.tanja.web_customer_tracker.model.developer.Developer;

public interface DeveloperService {

	public List<Developer> getAllDevelopers();
	public Developer getDeveloperById(int id);
	
}

package com.tanja.web_customer_tracker.DAO.developer;

import java.util.List;

import com.tanja.web_customer_tracker.model.developer.Developer;

public interface DeveloperDAO {

	public List<Developer> getAllDevelopers();
	
	public Developer getDeveloperById(int id);
	
	public void saveDeveloper(Developer developer);
	
	public void deleteDeveloper(int id);
	
}

package com.tanja.web_customer_tracker.service.bug;

import java.util.List;

import com.tanja.web_customer_tracker.model.bug.Bug;

public interface BugService {

	public List<Bug> getAllBugs();
	
	public Bug getBugById(int id);
	
	public void saveBug(Bug bug);
	
	public void deleteBug(int id);
	
}

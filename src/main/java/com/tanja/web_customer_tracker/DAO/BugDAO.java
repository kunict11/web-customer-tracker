package com.tanja.web_customer_tracker.DAO;

import java.util.List;

import com.tanja.web_customer_tracker.model.Bug;

public interface BugDAO {
	
	public List<Bug> getAllBugs();
	
	public Bug getBug(int id);
	
	public void saveBug(Bug bug);
	
	public void deleteBug(int id);

}

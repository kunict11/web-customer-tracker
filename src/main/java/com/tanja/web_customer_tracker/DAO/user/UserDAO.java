package com.tanja.web_customer_tracker.DAO.user;

import com.tanja.web_customer_tracker.model.User;

public interface UserDAO {
	
	public User findUserByEmail(String email);
	
}

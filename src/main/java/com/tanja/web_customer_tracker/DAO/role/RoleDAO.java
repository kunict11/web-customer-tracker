package com.tanja.web_customer_tracker.DAO.role;

import com.tanja.web_customer_tracker.model.Role;

public interface RoleDAO {

	public Role findRoleByName(String roleName);
	
}

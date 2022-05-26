package com.tanja.web_customer_tracker.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tanja.web_customer_tracker.DAO.role.RoleDAO;
import com.tanja.web_customer_tracker.model.Role;

@Service
public class RoleService {

	@Autowired
	private RoleDAO roleDao;
	
	@Transactional
	public Role findRoleByName(String name) {
		return roleDao.findRoleByName(name);
	}
}

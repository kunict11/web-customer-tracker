package com.tanja.web_customer_tracker.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.tanja.web_customer_tracker.DAO.user.UserDAO;
import com.tanja.web_customer_tracker.model.User;

@Service
public class UserService implements UserDetailsService {

	@Autowired
	private UserDAO userDao;
	
	@Override
	@Transactional
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
		User user = userDao.findUserByEmail(email);
		
		if (user == null) {
			throw new UsernameNotFoundException("User with given email not found");
		}
		
		return user;
	}

}

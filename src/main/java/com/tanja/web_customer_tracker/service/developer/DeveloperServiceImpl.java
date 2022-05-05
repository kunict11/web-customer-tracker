package com.tanja.web_customer_tracker.service.developer;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tanja.web_customer_tracker.DAO.developer.DeveloperDAO;
import com.tanja.web_customer_tracker.model.developer.Developer;

@Service
public class DeveloperServiceImpl implements DeveloperService {

	@Autowired
	private DeveloperDAO devDao;
	
	@Override
	@Transactional
	public Developer getDeveloperById(int id) {
		return devDao.getDeveloperById(id);
	}

	
	
}

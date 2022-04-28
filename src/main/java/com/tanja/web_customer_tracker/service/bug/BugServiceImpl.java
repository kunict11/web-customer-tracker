package com.tanja.web_customer_tracker.service.bug;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tanja.web_customer_tracker.DAO.bug.BugDAO;
import com.tanja.web_customer_tracker.model.bug.Bug;

@Service
public class BugServiceImpl implements BugService {

	@Autowired 
	private BugDAO bugDao;

	@Override
	@Transactional
	public List<Bug> getAllBugs() {
		return bugDao.getAllBugs();
	}

	@Override
	@Transactional
	public Bug getBugById(int id) {
		return bugDao.getBug(id);
	}

	@Override
	@Transactional
	public void saveBug(Bug bug) {
		bugDao.saveBug(bug);
	}

	@Override
	@Transactional
	public void deleteBug(int id) {
		bugDao.deleteBug(id);
	}
	
}

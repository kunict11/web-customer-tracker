package com.tanja.web_customer_tracker.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tanja.web_customer_tracker.DAO.ProjectDAO;
import com.tanja.web_customer_tracker.model.Project;

@Service
public class ProjectServiceImpl implements ProjectService {

	@Autowired
	private ProjectDAO projectDao;

	@Override
	@Transactional
	public List<Project> getAllProjects() {
		return projectDao.getAllProjects();
	}

	@Override
	@Transactional
	public Project getProjectById(int id) {
		return projectDao.getProject(id);
	}

	@Override
	@Transactional
	public void saveProject(Project project) {
		projectDao.saveProject(project);
	}

	@Override
	@Transactional
	public void deleteProject(int id) {
		projectDao.deleteProject(id);
	}
	
	
	
}

package com.tanja.web_customer_tracker.service.project;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tanja.web_customer_tracker.DAO.project.ProjectDAO;
import com.tanja.web_customer_tracker.model.project.Project;

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

	@Override
	@Transactional
	public List<Project> getAllProjectsWithBugs() {
		return projectDao.getAllProjectsWithBugs();
	}
	
	
	
}

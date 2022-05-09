package com.tanja.web_customer_tracker.DAO.project;

import java.util.List;

import org.hibernate.query.Query;
import org.hibernate.Hibernate;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.tanja.web_customer_tracker.model.project.Project;

@Repository
public class ProjectDAOImpl implements ProjectDAO {

	@Autowired
	private SessionFactory sf;
	
	@Override
	public List<Project> getAllProjects() {
		
		Session session = sf.getCurrentSession();
		List<Project> projects = null; 
		
		try {
			session.beginTransaction();
			
			Query<Project> query = session.createQuery("from Project", Project.class);
			projects = query.getResultList();
			
			session.getTransaction().commit();		
		} finally {
			session.close();
		}
		
		return projects;
	}

	@Override
	public Project getProject(int id) {
		
		Session session = sf.getCurrentSession();
		Project project = null;
		
		try {
			session.beginTransaction();
			
			project = session.get(Project.class, id);
			
			session.getTransaction().commit();		
		} finally {
			session.close();
		}

		
		return project;
	}

	@Override
	public void saveProject(Project project) {
		
		Session session = sf.getCurrentSession();
		
		try {
			session.beginTransaction();
			
			session.saveOrUpdate(project);
			
			session.getTransaction().commit();
			
		} finally {
			session.close();
		}
	}

	@Override
	public void deleteProject(int id) {
		
		Session session = sf.getCurrentSession();
		Project project = null;
		
		try {
			session.beginTransaction();
			
			project = session.get(Project.class, id);
			
			session.delete(project);
			
			session.getTransaction().commit();
		} finally {
			session.close();
		}
		
	}

	@Override
	public List<Project> getAllProjectsWithBugs() {
		
		Session session = sf.getCurrentSession();
		List<Project> projects = null;
		
		try {
			session.beginTransaction();
			
			Query<Project> query = session.createQuery("from Project order by name", Project.class);
			projects = query.getResultList();
			
			for (Project project : projects) {
				Hibernate.initialize(project.getBugs());
			}
			
			session.getTransaction().commit();	
			
		} finally {
			session.close();
		}
	
		return projects;
	}

	

}

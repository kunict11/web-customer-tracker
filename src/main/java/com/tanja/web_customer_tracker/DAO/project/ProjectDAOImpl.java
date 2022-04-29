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
		
		session.beginTransaction();
		
		Query<Project> query = session.createQuery("from Project", Project.class);
		List<Project> projects = query.getResultList();
		
		session.getTransaction().commit();		
		
		return projects;
	}

	@Override
	public Project getProject(int id) {
		
		Session session = sf.getCurrentSession();
		
		session.beginTransaction();
		
		Project project = session.get(Project.class, id);
		
		session.getTransaction().commit();
		
		return project;
	}

	@Override
	public void saveProject(Project project) {
		
		Session session = sf.getCurrentSession();
		
		session.beginTransaction();
		
		session.saveOrUpdate(project);
		
		session.getTransaction().commit();
	}

	@Override
	public void deleteProject(int id) {
		
		Session session = sf.getCurrentSession();
		
		session.beginTransaction();
		
		Project project = session.get(Project.class, id);
		
		session.delete(project);
		
		session.getTransaction().commit();
		
	}

	@Override
	public List<Project> getAllProjectsWithBugs() {
		
		Session session = sf.getCurrentSession();
		
		session.beginTransaction();
		
		Query<Project> query = session.createQuery("from Project order by name", Project.class);
		List<Project> projects = query.getResultList();
		
		for (Project project : projects) {
			Hibernate.initialize(project.getBugs());
		}
		
		session.getTransaction().commit();		
		
		return null;
	}

	

}

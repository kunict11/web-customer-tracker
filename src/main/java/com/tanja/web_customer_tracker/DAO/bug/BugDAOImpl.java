package com.tanja.web_customer_tracker.DAO.bug;

import java.util.List;

import org.hibernate.Hibernate;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.tanja.web_customer_tracker.model.bug.Bug;
import com.tanja.web_customer_tracker.model.project.Project;

@Repository
public class BugDAOImpl implements BugDAO {

	@Autowired
	private SessionFactory sf;

	@Override
	public List<Bug> getAllBugs() {
		
		Session session = sf.getCurrentSession();
		
		session.beginTransaction();
		
		Query<Bug> query = session.createQuery("from Bug", Bug.class);
		List<Bug> bugs = query.getResultList();
		
		session.getTransaction().commit();
		
		return bugs;
	}

	@Override
	public Bug getBug(int id) {
		
		Session session = sf.getCurrentSession();
		
		session.beginTransaction();
		
		Bug bug = session.get(Bug.class, id);
		Hibernate.initialize(bug.getProjects());
		
		session.getTransaction().commit();
		
		return bug;
	}

	@Override
	public void saveBug(Bug bug) {
		
		Session session = sf.getCurrentSession();
		
		session.beginTransaction();
		
		session.saveOrUpdate(bug);
		
		session.getTransaction().commit();
		
	}

	@Override
	public void deleteBug(int id) {
		
		Session session = sf.getCurrentSession();
		
		session.beginTransaction();
		
		Bug bug = session.get(Bug.class, id);
		session.delete(bug);
		
		session.getTransaction().commit();
	}
	
	
}

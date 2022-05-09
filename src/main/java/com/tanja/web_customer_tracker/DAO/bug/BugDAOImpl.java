package com.tanja.web_customer_tracker.DAO.bug;

import java.util.List;

import org.hibernate.Hibernate;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.tanja.web_customer_tracker.model.bug.Bug;

@Repository
public class BugDAOImpl implements BugDAO {

	@Autowired
	private SessionFactory sf;

	@Override
	public List<Bug> getAllBugs() {
		
		Session session = sf.getCurrentSession();
		
		List<Bug> bugs = null;
		
		try {
			session.beginTransaction();
			
			Query<Bug> query = session.createQuery("from Bug", Bug.class);
			bugs = query.getResultList();
			
			for (Bug bug : bugs) {
				Hibernate.initialize(bug.getProjects());
			}
			
			session.getTransaction().commit();
		} finally {
			session.close();
		}
		
		return bugs;
	}

	@Override
	public Bug getBug(int id) {
		
		Session session = sf.getCurrentSession();
		Bug bug = null;
		
		try {			
			session.beginTransaction();
			
			bug = session.get(Bug.class, id);
			Hibernate.initialize(bug.getProjects());
			
			session.getTransaction().commit();
		} finally {
			session.close();
		}
		
		return bug;
	}

	@Override
	public void saveBug(Bug bug) {
		
		Session session = sf.getCurrentSession();
		
		try {
			session.beginTransaction();
			
			session.saveOrUpdate(bug);
			
			session.getTransaction().commit();
		} finally {
			session.close();
		}
	}

	@Override
	public void deleteBug(int id) {
		
		Session session = sf.getCurrentSession();
		
		try {			
			session.beginTransaction();
			
			Bug bug = session.get(Bug.class, id);
			session.delete(bug);
			
			session.getTransaction().commit();
		} finally {
			session.close();
		}
	}
	
	
}

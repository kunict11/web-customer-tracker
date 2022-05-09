package com.tanja.web_customer_tracker.DAO.developer;

import java.util.List;

import org.hibernate.query.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.tanja.web_customer_tracker.model.developer.Developer;

@Repository
public class DeveloperDAOImpl implements DeveloperDAO {

	@Autowired
	private SessionFactory sf;

	@Override
	public Developer getDeveloperById(int id) {
		
		Session session = sf.getCurrentSession();
		
		session.beginTransaction();
		
		Developer dev = session.get(Developer.class, id);
		
		session.getTransaction().commit();
		return dev;
	}

	@Override
	public List<Developer> getAllDevelopers() {
		
		Session session = sf.getCurrentSession();
		
		session.beginTransaction();
		
		Query<Developer> query = session.createQuery("from Developer", Developer.class);
		List<Developer> developers = query.getResultList();
		
		
		session.getTransaction().commit();
		
		return developers;
		
	}

	@Override
	public void saveDeveloper(Developer developer) {
		
		Session session = sf.getCurrentSession();
		
		session.beginTransaction();
		
		session.saveOrUpdate(developer);
		
		session.getTransaction().commit();		
	}

	@Override
	public void deleteDeveloper(int id) {
		Session session = sf.getCurrentSession();
		
		session.beginTransaction();
		
		Developer dev = session.get(Developer.class, id);
		session.delete(dev);
		
		session.getTransaction().commit();	
		
	}
	
	
	
	
}

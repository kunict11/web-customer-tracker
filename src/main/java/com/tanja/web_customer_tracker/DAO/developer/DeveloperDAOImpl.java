package com.tanja.web_customer_tracker.DAO.developer;

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
}

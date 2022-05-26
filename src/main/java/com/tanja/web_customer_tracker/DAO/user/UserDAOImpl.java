package com.tanja.web_customer_tracker.DAO.user;

import org.hibernate.Hibernate;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.tanja.web_customer_tracker.model.User;

@Repository
public class UserDAOImpl implements UserDAO {

	@Autowired
	private SessionFactory sf;
	
	@Override
	public User findUserByEmail(String email) {
		Session session = sf.getCurrentSession();
		User user = null;
		
		try {
			session.beginTransaction();
			
			Query<User> query = session.createQuery("from User where email=:userEmail", User.class);
			query.setParameter("userEmail", email);
			user = query.uniqueResult();
			Hibernate.initialize(user.getRoles());
			
			session.getTransaction().commit();
			
		} finally {
			session.close();
		}
		
		return user;
	}

}

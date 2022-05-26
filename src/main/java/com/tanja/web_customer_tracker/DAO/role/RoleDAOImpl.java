package com.tanja.web_customer_tracker.DAO.role;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.tanja.web_customer_tracker.model.Role;

@Repository
public class RoleDAOImpl implements RoleDAO{

	@Autowired
	private SessionFactory sf;

	@Override
	public Role findRoleByName(String roleName) {
		
		Session session = sf.getCurrentSession();
		Role role = null;
		
		try {
			session.beginTransaction();
			
			Query<Role> query = session.createQuery("from Role where name=:roleName", Role.class);
			query.setParameter("roleName", roleName);
			role = query.getSingleResult();
			
			session.getTransaction().commit();
		} finally {
			session.close();
		}
		
		return role;
	}
	
	
}

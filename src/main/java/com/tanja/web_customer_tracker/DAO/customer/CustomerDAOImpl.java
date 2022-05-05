package com.tanja.web_customer_tracker.DAO.customer;

import java.util.List;

import org.hibernate.Hibernate;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.tanja.web_customer_tracker.model.customer.Customer;

@Repository
public class CustomerDAOImpl implements CustomerDAO {
	
	@Autowired
	private SessionFactory sf;
	
	@Override
	public List<Customer> getCustomers() {
		
		Session session = sf.getCurrentSession();
		
		session.beginTransaction();
		
		Query<Customer> query = session.createQuery("from Customer order by firstName", Customer.class);
		List<Customer> customers = query.getResultList();
		session.getTransaction().commit();
		
		return customers;
	}

	@Override
	public void saveCustomer(Customer c) {
		Session session = sf.getCurrentSession();
		
		session.beginTransaction();
		
		session.saveOrUpdate(c);
		
		session.getTransaction().commit();
		
	}

	@Override
	public void deleteCustomer(int customerId) {
		Session session = sf.getCurrentSession();
		
		session.beginTransaction();
		
		Customer customerFromDB = session.get(Customer.class, customerId);
		
		session.delete(customerFromDB);
		
		session.getTransaction().commit();
		
	}

	@Override
	public Customer getCustomer(int id) {
		Session session = sf.getCurrentSession();
		
		session.beginTransaction();
		
		Customer c = session.get(Customer.class, id);
		session.getTransaction().commit();
		
		
		return c;
	}

	@Override
	public Customer findByEmail(String email) {
		
		Session session = sf.getCurrentSession();
		
		session.beginTransaction();
		
		Query<Customer> query = session.createQuery("from Customer where email=:customerEmail", Customer.class);
		query.setParameter("customerEmail", email);
		Customer customer = query.uniqueResult();
		Hibernate.initialize(customer.getReportedBugs());
		
		session.getTransaction().commit();
		
		return customer;
	}

	
	
}

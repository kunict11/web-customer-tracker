package com.tanja.web_customer_tracker.model.customer;


import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.tanja.web_customer_tracker.model.User;
import com.tanja.web_customer_tracker.model.bug.Bug;

@Entity
@Table(name = "customer")
@PrimaryKeyJoinColumn(name = "id")
public class Customer extends User{
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "customer_details_id")
	private CustomerDetails customerDetails;
	
	@JsonIgnore
	@OneToMany(mappedBy = "customer", cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH})
	private List<Bug> reportedBugs;

	public Customer() {
	}
	
	public Customer(String firstName, String lastname, String email, CustomerDetails customerDetails) {
		super(firstName, lastname, email);
		this.customerDetails = customerDetails;
	}

	public CustomerDetails getCustomerDetails() {
		return customerDetails;
	}

	public void setCustomerDetails(CustomerDetails customerDetails) {
		this.customerDetails = customerDetails;
	}
	
	public List<Bug> getReportedBugs() {
		return reportedBugs;
	}

	public void setReportedBugs(List<Bug> reportedBugs) {
		this.reportedBugs = reportedBugs;
	}
	
	public void reportBug(Bug bug) {
		if (reportedBugs == null) {
			reportedBugs = new ArrayList<>();
		}
		
		reportedBugs.add(bug);
		bug.setCustomer(this);
	}

	@Override
	public String toString() {
		return "Customer [id=" + getId() + ", firstName=" + getFirstName() + ", lastName=" + getLastName() + ", email=" + getEmail() + "]";
	}

}

package com.tanja.web_customer_tracker.model.bug;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.tanja.web_customer_tracker.model.customer.Customer;
import com.tanja.web_customer_tracker.model.developer.Developer;
import com.tanja.web_customer_tracker.model.project.Project;

@Entity
@Table(name = "bug")
public class Bug {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;
	
	@Column(name = "description")
	private String description;
	
	@Column(name = "component")
	private String component;
	
	@Enumerated(value = EnumType.STRING)
	@Column(name = "priority")
	private Priority priority;
	
	@Enumerated(value = EnumType.STRING)
	@Column(name = "status")
	private Status status;
	
	@ManyToMany(cascade = { CascadeType.MERGE, CascadeType.REFRESH })
	@JoinTable(name = "project_bug", joinColumns = @JoinColumn(name = "bug_id"), inverseJoinColumns = @JoinColumn(name = "project_id"))
	private List<Project> projects;
	
	@ManyToOne(cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH})
	@JoinColumn(name = "customer_id")
	private Customer customer;
	
	@ManyToOne(cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH})
	@JoinColumn(name = "developer_id")
	private Developer assignedDeveloper;
	
	public Bug() {
	}

	public Bug(String description, String component, Priority priority, Status status, Customer customer) {
		this.description = description;
		this.component = component;
		this.priority = priority;
		this.status = status;
		
		if (status == null) {
			this.status = Status.UNRESOLVED;
		}
		
		this.customer = customer;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getComponent() {
		return component;
	}

	public void setComponent(String component) {
		this.component = component;
	}

	public Priority getPriority() {
		return priority;
	}

	public void setPriority(Priority priority) {
		this.priority = priority;
	}

	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}

	public List<Project> getProjects() {
		return projects;
	}

	public void setProjects(List<Project> projects) {
		this.projects = projects;
	}
	
	public void addProject(Project project) {
		if (projects == null) {
			projects = new ArrayList<>();
		}
		
		projects.add(project);
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public Developer getAssignedDeveloper() {
		return assignedDeveloper;
	}

	public void setAssignedDeveloper(Developer assignedDeveloper) {
		this.assignedDeveloper = assignedDeveloper;
	}

	@Override
	public String toString() {
		return "Bug [description=" + description + ", component=" + component + ", priority=" + priority + ", status="
				+ status + " reported by " + customer.getFirstName() + " " + customer.getLastName() + "]";
	}
	
	
	
}

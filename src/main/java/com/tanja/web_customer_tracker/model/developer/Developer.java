package com.tanja.web_customer_tracker.model.developer;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import com.tanja.web_customer_tracker.model.User;
import com.tanja.web_customer_tracker.model.project.Project;

@JsonIdentityInfo(
		scope = Developer.class,
		generator = ObjectIdGenerators.PropertyGenerator.class, 
		property = "id")
@Entity
@Table(name = "developer")
@PrimaryKeyJoinColumn(name = "id")
public class Developer extends User {
	
	@ManyToOne(cascade = { CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REFRESH })
	@JoinColumn(name = "project_id")
	private Project project;

	public Developer(String firstName, String lastName, String email, Project project) {
		super(firstName, lastName, email);
		this.project = project;
	}

	public Developer() {
	}

	public Project getProject() {
		return project;
	}

	public void setProject(Project project) {
		this.project = project;
	}

	@Override
	public String toString() {
		return "Developer [id=" + getId() + ", firstName=" + getFirstName() + ", lastName=" + getLastName() + ", email=" + getEmail() + ", project=" + project.getName() + "]";
	}
	
}

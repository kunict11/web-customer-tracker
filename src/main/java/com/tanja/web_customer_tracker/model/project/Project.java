package com.tanja.web_customer_tracker.model.project;

import java.util.ArrayList;
import java.util.List;


import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.tanja.web_customer_tracker.model.bug.Bug;
import com.tanja.web_customer_tracker.model.developer.Developer;

@Entity
@Table(name = "project")
public class Project {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;
	
	@Column(name = "name")
	private String name;
	
	@Column(name = "component")
	private String component;
	
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinColumn(name = "project_id")
	private List<Developer> developers;

	@JsonIgnore
	@ManyToMany(cascade = { CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REFRESH })
	@JoinTable(name = "project_bug", joinColumns = @JoinColumn(name = "project_id"), inverseJoinColumns = @JoinColumn(name = "bug_id"))
	private List<Bug> bugs;
	
	public Project(int id, String name, String component, List<Developer> developers) {
		this.id = id;
		this.name = name;
		this.component = component;
		this.developers = developers;
	}

	public Project() {
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getComponent() {
		return component;
	}

	public void setComponent(String component) {
		this.component = component;
	}

	public List<Bug> getBugs() {
		return bugs;
	}

	public void setBugs(List<Bug> bugs) {
		this.bugs = bugs;
	}
	
	public void addBug(Bug bug) {
		if (bugs == null) {
			bugs = new ArrayList<>();
		}
		bugs.add(bug);
	}
	
	public List<Developer> getDevelopers() {
		return developers;
	}

	public void setDevelopers(List<Developer> developers) {
		this.developers = developers;
	}
	
	public void addDeveloper(Developer dev) {
		if (developers == null) {
			developers = new ArrayList<>();
		}
		
		developers.add(dev);
	}

	@Override
	public String toString() {
		return "Project [id=" + id + ", name=" + name + ", component=" + component + "]";
	}	
	
}

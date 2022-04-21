package com.tanja.web_customer_tracker.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;

@Entity
@Table(name = "customer_details")
public class CustomerDetails {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;
	
	@Column(name = "address")
	private String address;
	
	@Column(name = "birthday")
	private Date birthday;
	
	@Enumerated(EnumType.STRING)
	@Column(name = "gender")
	private GenderEnum gender;
	
	@Lob
	@Column(name = "profile_picture", columnDefinition = "BLOB")
	private byte[] profilePicture;
	
	
	public CustomerDetails(String address, Date birthday, GenderEnum gender, byte[] profilePicture) {
		this.address = address;
		this.birthday = birthday;
		this.gender = gender;
		this.profilePicture = profilePicture;
	}

	public CustomerDetails() {
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public Date getBirthday() {
		return birthday;
	}

	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}

	public GenderEnum getGender() {
		return gender;
	}

	public void setGender(GenderEnum gender) {
		this.gender = gender;
	}

	public byte[] getProfilePicture() {
		return profilePicture;
	}

	public void setProfilePicture(byte[] profilePicture) {
		this.profilePicture = profilePicture;
	}
	
}

package com.backend.developertrialtask.model;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;


@Entity
@Table(name = "users")
public class Users {
	
	//Declare table fields and add validation to prevent sending null values for key columns
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY) // Use GenerationType
	private int id;
	
	@NotEmpty
	private String fullName;
	@Email
	private String email;
	private String phone;
	@Column(nullable = false, updatable = false)
    private LocalDateTime createdAt;

	
//	@Size(min=8, message="Minimum password length is 8 characters")
//	private String password;
	public int getId() {
		return id;
	}
	public String getFullName() {
		return fullName;
	}
	public String getEmail() {
		return email;
	}
	public String getPhone() {
		return phone;
	}

	public void setId(int id) {
		this.id = id;
	}
	public void setFullName(String fullName) {
		this.fullName = fullName;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	

}

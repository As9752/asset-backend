package com.kloudspot.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "user")
public class User {

	@Id
	private String userId;
	private String name;
	private String userEmail;
	private Roles roles; // Consider using an Enum or a List of roles

	public User() {
		// Default constructor
	}

	public User(String userId, String name, String userEmail, Roles roles) {
		this.userId = userId;
		this.name = name;
		this.userEmail = userEmail;
		this.roles = roles;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getUserEmail() {
		return userEmail;
	}

	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}

	public Roles getRoles() {
		return roles;
	}

	public void setRoles(Roles roles) {
		this.roles = roles;
	}

	@Override
	public String toString() {
		return "User [userId=" + userId + ", name=" + name + ", userEmail=" + userEmail + ", roles=" + roles + "]";
	}
}

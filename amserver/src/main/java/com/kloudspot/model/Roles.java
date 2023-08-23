package com.kloudspot.model;

public enum Roles {
	SUPER_ADMIN("Super Admin"), ADMIN("Admin"), EMPLOYEE("Employee");

	private final String role;

	Roles(String role) {
		this.role = role;
	}

	public String getRole() {
		return role;
	}

}

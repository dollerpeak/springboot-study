package com.shm.user;

public enum UserRole {
	ROLE_USER("USER"), 
	ROLE_SELLER("SELLER"), 
	ROLE_ADMIN("ADMIN");

	private String roleName;

	UserRole(String name) {
		roleName = name;
	}

	public String getName() {
		return roleName;
	}
}

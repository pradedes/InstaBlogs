package com.instablog.api.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class User {
	@Id
	//@Column("length=10","nonnullable = true")
	private String userId;
	
	private String userName;
	
	private boolean isAdmin;
	
	private String email;
	
	//@Column("length=256","nonnullable = true")
	private String passwordHash;
	
	private List<String> userHashTags;
	
	public List<String> getUserHashTags() {
		return userHashTags;
	}

	public void setUserHashTags(List<String> userHashTags) {
		this.userHashTags = userHashTags;
	}

	public boolean isAdmin() {
		return isAdmin;
	}

	public void setAdmin(boolean isAdmin) {
		this.isAdmin = isAdmin;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}


	public String getPasswordHash() {
		return passwordHash;
	}

	public void setPasswordHash(String passwordHash) {
		this.passwordHash = passwordHash;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

}

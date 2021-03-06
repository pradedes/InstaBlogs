package com.instablog.api.entity;

import org.mongodb.morphia.annotations.Entity;
import org.mongodb.morphia.annotations.Id;

@Entity
public class User {

	public static final String FIND_ALL = "User.findAll";

	// @Column("length=10","nonnullable = true")
	
	@Id
	//@Column(name = "USER_LOGIN_ID")
	private String userLoginId;


	private String fullName;

	// private boolean isAdmin;
	private String email;

	// @Column("length=256","nonnullable = true")
	private String password;
	
	private String salt;
	
	// @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	//// @JoinTable(name = "USER_HASHTAGS", joinColumns = { @JoinColumn(name =
	// "USER_ID") }, inverseJoinColumns = { @JoinColumn(name = "VALUE") })
	// private Set<HashTag> userHashTags;
	//
	// public Set<HashTag> getUserHashTags() {
	// return userHashTags;
	// }
	//
	// public void setUserHashTags(Set<HashTag> userHashTags) {
	// this.userHashTags = userHashTags;
	// }

	// public boolean isAdmin() {
	// return isAdmin;
	// }
	//
	// public void setAdmin(boolean isAdmin) {
	// this.isAdmin = isAdmin;
	// }

	public String getSalt() {
		return salt;
	}

	public void setSalt(String salt) {
		this.salt = salt;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}


	public String getUserName() {
		return fullName;
	}

	public void setUserName(String fullName) {
		this.fullName = fullName;
	}
	
	public String getUserLoginId() {
		return userLoginId;
	}

	public void setUserLoginId(String userLoginId) {
		this.userLoginId = userLoginId;
	}
}

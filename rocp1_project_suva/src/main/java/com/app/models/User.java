package com.app.models;

public class User {
	private int userId; 
	private String username; 
	private String password;
	private String firstName; 
	private String lastName; 
	private String email; 
	private String updatePassword;
	private Role role;
	private int roleID;

	public String getUpdatePassword() {
		return updatePassword;
	}


	public void setUpdatePassword(String updatePassword) {
		this.updatePassword = updatePassword;
	}
	
	public User() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	public User(int userId, String username, String firstName, String lastName, String email,
			Role role) {
		super();
		this.userId = userId;
		this.username = username;		
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.role = role;
	}
	
	public User(String username, String password, String firstName, String lastName, String email, Role role) {
		super();		
		this.username = username;	
		this.password = password;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.role = role;
	}
	
	public User(int userId, String username, String password, String firstName, String lastName, String email, Role role) {
		super();
		this.userId = userId;
		this.username = username;
		this.password = password;
		this.role = role;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
	}

	public int getRoleID() {
		return roleID;
	}


	public void setRoleID(int roleID) {
		this.roleID = roleID;
	}


	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Role getRole() {
		return role;
	}
	public void setRole(Role role) {
		this.role = role;
	}
	@Override
	public String toString() {
		return "User [userId=" + userId + ", username=" + username + ", password=" + password + ", firstName="
				+ firstName + ", lastName=" + lastName + ", email=" + email + ", role=" + role + "]";
	}

}

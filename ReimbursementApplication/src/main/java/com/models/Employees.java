package com.models;

public class Employees {
	
	
	
	private int id;
	private String password;
	private String firstName;
	private String lastName;
	private String email;
	private int userRole;
	private String username;
	
	
	
	
	@Override
	public String toString() {
		return "Employees [password=" + password + ", firstName=" + firstName + ", lastName=" + lastName + ", email="
				+ email + ", userRole=" + userRole + ", username=" + username + "]";
	}
	
	
	
	//Constructions
	
	
	
	
	public Employees() {
		super();
	}
	
	public Employees(String password, String firstName, String lastName, String email, int userRole,
			String username) {
		super();
		this.password = password;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.userRole = userRole;
		this.username = username;
	}


	
	
	//Getters and Setters
	
	
	
	

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
	public int getUserRole() {
		return userRole;
	}
	public void setUserRole(int userRole) {
		this.userRole = userRole;
	}



	public int getId() {
		return id;
	}



	public void setId(int id) {
		this.id = id;
	}
	

	
	
}

package org.entity;

public class loginpeople {
	private String username,password;

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

	public loginpeople(String username, String password) {
		super();
		this.username = username;
		this.password = password;
	}

	public loginpeople() {
		super();
	}

	
	
}

package com.gcu.data;

public class DbCredentials {

	
	private String server = "jdbc:derby:C:\\Users\\Jordan\\MyDB";
	private String username = "admin";
	private String password = "password";
	
	
	public DbCredentials(String server, String username, String password) {
		super();
		this.server = server;
		this.username = username;
		this.password = password;
	}
	
	
	public String getServer() {
		return server;
	}
	public void setServer(String server) {
		this.server = server;
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
	
	
	
	
	
}

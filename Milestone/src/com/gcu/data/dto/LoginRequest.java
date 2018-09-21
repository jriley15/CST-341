package com.gcu.data.dto;

import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;

public class LoginRequest {

	
	@NotEmpty
	@Email
	private String email;

	@NotEmpty
	@Size(min = 3, max = 30)
	private String password;

	public LoginRequest(String email, @Size(min = 3, max = 30) String password) {
		super();
		this.email = email;
		this.password = password;
	}

	public LoginRequest() {
		email = "";
		password = "";
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
	

}

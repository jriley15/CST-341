package com.gcu.data.dto;

import javax.validation.constraints.AssertTrue;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;

public class RegisterRequest {

	@NotEmpty
	@Size(min = 3, max = 30)
	private String firstName;

	@NotEmpty
	@Size(min = 3, max = 30)
	private String lastName;
	
	@NotEmpty
	@Email
	private String email;

	@NotEmpty
	@Size(min = 3, max = 30)
	private String password;

	@NotEmpty
	@Size(min = 3, max = 30)
	private String passwordConfirm;
	
	@AssertTrue(message = "Passwords must match")
	private boolean isValid() {
		return this.password.equals(this.passwordConfirm);
	}

	public RegisterRequest(@NotNull @Size @Size(min = 3, max = 30) String firstName,
			@NotNull @Size(min = 3, max = 30) String lastName, @NotNull @Email String email,
			@NotNull @Size(min = 3, max = 30) String password,
			@NotNull @Size(min = 3, max = 30) String passwordConfirm) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.password = password;
		this.passwordConfirm = passwordConfirm;
	}

	public RegisterRequest() {
		super();
		this.firstName = "";
		this.lastName = "";
		this.email = "";
		this.password = "";
		this.passwordConfirm = "";
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

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getPasswordConfirm() {
		return passwordConfirm;
	}

	public void setPasswordConfirm(String passwordConfirm) {
		this.passwordConfirm = passwordConfirm;
	}
	
	
	
	

}

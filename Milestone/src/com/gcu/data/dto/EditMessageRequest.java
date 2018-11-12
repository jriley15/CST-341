package com.gcu.data.dto;

import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotEmpty;

public class EditMessageRequest {

	
	@NotEmpty
	@Size(min = 1, max = 100)
	private String message;

	private int id;
	
	public EditMessageRequest() {
		message = "";
	}
	public EditMessageRequest(int id, String message) {
		this.id = id;
		this.message = message;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
	
	
	
	
	
}

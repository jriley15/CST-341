package com.gcu.data.dto;

import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotEmpty;

public class SendMessageRequest {

	
	@NotEmpty
	@Size(min = 1, max = 100)
	private String message;

	
	public SendMessageRequest() {
		message = "";
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
	
	
	
	
}

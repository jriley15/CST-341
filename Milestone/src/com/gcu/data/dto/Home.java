package com.gcu.data.dto;

public class Home {

	private String message;


	public Home() {
		this.message = "";
	}
	
	public Home(String message) {
		super();
		this.message = message;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
	
	
	
	
}

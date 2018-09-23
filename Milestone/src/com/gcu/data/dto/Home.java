package com.gcu.data.dto;


//home view model (contains message string for notifying user when actions are successful)
public class Home {

	
	//message field
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

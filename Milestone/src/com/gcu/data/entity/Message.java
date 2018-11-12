package com.gcu.data.entity;

import java.sql.Date;

public class Message {

	
	private int id;
	
	private int userId;
	
	private String content;
	
	private Date createdOn;

	
	
	public Message(int id, int userId, String content, Date createdOn) {
		this.id = id;
		this.userId = userId;
		this.content = content;
		this.createdOn = createdOn;
	}

	public Message() {
		// TODO Auto-generated constructor stub
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Date getCreatedOn() {
		return createdOn;
	}

	public void setCreatedOn(Date createdOn) {
		this.createdOn = createdOn;
	}
	
	
	
	
	
}

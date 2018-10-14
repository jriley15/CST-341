package com.gcu.data.dto;

import java.sql.Date;

import com.gcu.data.entity.Message;

public class ChatMessage extends Message {


	private String displayName;


	public ChatMessage(int id, int userId, String content, Date createdOn, String displayName) {
		super(id, userId, content, createdOn);
		this.displayName = displayName;
	}

	public String getDisplayName() {
		return displayName;
	}

	public void setDisplayName(String displayName) {
		this.displayName = displayName;
	}


}

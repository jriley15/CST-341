package com.gcu.services;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.gcu.data.DataAccessInterface;
import com.gcu.data.dto.ChatMessage;
import com.gcu.data.dto.SendMessageRequest;
import com.gcu.data.entity.Message;
import com.gcu.data.entity.User;

public class ChatService implements IChatService {

	
	private DataAccessInterface<ChatMessage> messageDAO;
	
	
	//method for getting all messages from data layer
	public List<ChatMessage> getMessages() {
		
		List<ChatMessage> messages = this.messageDAO.findAll();
		
		return messages;

	}
	
	//method for creating new message via data layer
	public boolean createMessage(User user, SendMessageRequest request) {

		ChatMessage message = new ChatMessage(0, user.getId(), request.getMessage(), new java.sql.Date(Calendar.getInstance().getTime().getTime()), null);

		return this.messageDAO.create(message);

	}
	
	

	@Autowired
	public void setMessageDAO(DataAccessInterface<ChatMessage> service) {
		messageDAO = service;
	}

	
	
	
}

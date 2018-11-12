package com.gcu.services;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.gcu.data.DataAccessInterface;
import com.gcu.data.dto.ChatMessage;
import com.gcu.data.dto.EditMessageRequest;
import com.gcu.data.dto.SendMessageRequest;
import com.gcu.data.entity.Message;
import com.gcu.data.entity.User;

public class ChatService implements IChatService {

	
	private DataAccessInterface<ChatMessage> messageDAO;
	
	
	//gets one message for editing based on id
	public ChatMessage getMessage(User user, int messageId) {
		
		//dao find function
		ChatMessage message = messageDAO.findById(messageId);
		
		//check if message was successfully loaded, and user is the creator of the message
		if (message != null && message.getUserId() == user.getId()) {
			
			//success, return message
			return message;
		}
		
		return null;
		
	}
	
	//method for getting all messages from data layer
	public List<ChatMessage> getMessages() {
		
		//dao find all function
		List<ChatMessage> messages = this.messageDAO.findAll();
		
		//return list of messages
		return messages;

	}
	
	//method for creating new message via data layer
	public boolean createMessage(User user, SendMessageRequest request) {

		//create new instance of chat message
		ChatMessage message = new ChatMessage(0, user.getId(), request.getMessage(), new java.sql.Date(Calendar.getInstance().getTime().getTime()), null);

		//dao create function
		return this.messageDAO.create(message);

	}
	
	//method for deleting message based on id
	@Override
	public boolean deleteMessage(User user, int messageId) {
		
		
		ChatMessage message = messageDAO.findById(messageId);
				
		if (message != null && message.getUserId() == user.getId()) {
			
			return this.messageDAO.delete(message);
		}

		return false;
	}

	//method for updating a passed in message
	@Override
	public boolean editMessage(User user, EditMessageRequest editMessage) {
		// TODO Auto-generated method stub
		
		//find message
		ChatMessage message = messageDAO.findById(editMessage.getId());
		
		//ensure the user is the original creator of this message
		if (message != null && message.getUserId() == user.getId()) {
			
			//set messages content to the edited version that was passed in
			message.setContent(editMessage.getMessage());
			
			//dao update function
			return this.messageDAO.update(message);
			
		}
		
		return false;
	}
	
	
	//message dao dependency setter
	@Autowired
	public void setMessageDAO(DataAccessInterface<ChatMessage> service) {
		messageDAO = service;
	}
	
}

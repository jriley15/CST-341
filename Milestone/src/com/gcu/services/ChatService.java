package com.gcu.services;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import com.gcu.data.dto.ChatMessage;
import com.gcu.data.dto.SendMessageRequest;
import com.gcu.data.entity.Message;
import com.gcu.data.entity.User;

public class ChatService extends Service implements IChatService {

	
	
	public ChatService() {

		super();
		
	}

	
	public List<ChatMessage> getMessages() {
		
		List<ChatMessage> messages = this.dbContext.getMessages().getAll();
		

		return messages;
		
		
	}
	
	
	public boolean createMessage(User user, SendMessageRequest request) {
		
		Message message = new Message(0, user.getId(), request.getMessage(), new java.sql.Date(Calendar.getInstance().getTime().getTime()));
		
		return this.dbContext.getMessages().create(message);
		
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}

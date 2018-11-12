package com.gcu.services;

import java.util.List;

import com.gcu.data.dto.ChatMessage;
import com.gcu.data.dto.EditMessageRequest;
import com.gcu.data.dto.SendMessageRequest;
import com.gcu.data.entity.User;

public interface IChatService {
	
	
	
	public List<ChatMessage> getMessages();
	

	public boolean createMessage(User user, SendMessageRequest request);
	
	
	public boolean deleteMessage(User user, int messageId);
	
	ChatMessage getMessage(User user, int id);
	
	boolean editMessage(User user, EditMessageRequest message);
	
}

package com.gcu.data.tables;

import java.util.List;

import com.gcu.data.dto.ChatMessage;
import com.gcu.data.entity.Message;
import com.gcu.data.entity.User;

public interface IMessages extends ITable {

	

	public boolean create(Message m);

	public List<ChatMessage> getAll();
	


	
	
}

package com.gcu.data;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import org.springframework.jdbc.support.rowset.SqlRowSet;

import com.gcu.data.dto.ChatMessage;
import com.gcu.data.entity.Message;


public class MessageDAO extends Spring implements DataAccessInterface<ChatMessage> {

	@Override
	public List<ChatMessage> findAll() {
		
		List<ChatMessage> messages = new ArrayList<ChatMessage>();
		
		//select query
		String query = "SELECT * FROM MILESTONE.MESSAGES INNER JOIN MILESTONE.USERS ON MILESTONE.MESSAGES.USER_ID=MILESTONE.USERS.ID";
		
		SqlRowSet srs = jdbcTemplate.queryForRowSet(query);
		
		while(srs.next())
		{
			int userId = srs.getInt("ID");
			int messageId = srs.getInt("MESSAGE_ID");
			String content = srs.getString("CONTENT");
			Date date = srs.getDate("CREATED_ON");
			String displayName = srs.getString("FIRST_NAME") + " "+srs.getString("LAST_NAME");
			
			messages.add(new ChatMessage(messageId, userId, content, date, displayName));

		}
		
		return messages;
	}

	@Override
	public ChatMessage findById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean create(ChatMessage m) {
		
		String query = "INSERT INTO MILESTONE.MESSAGES (USER_ID, CONTENT, CREATED_ON)" + " values (?, ?, ?)";

		
		int result = jdbcTemplate.update(query, m.getUserId(), 
				m.getContent(), 
				m.getCreatedOn());

		
		return (result > 0);
		
	}

	@Override
	public boolean update(ChatMessage t) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean delete(ChatMessage t) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public ChatMessage findBy(ChatMessage t) {
		// TODO Auto-generated method stub
		return null;
	}

}

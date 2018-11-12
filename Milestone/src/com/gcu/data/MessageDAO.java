package com.gcu.data;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import org.springframework.jdbc.support.rowset.SqlRowSet;

import com.gcu.data.dto.ChatMessage;
import com.gcu.data.entity.Message;

public class MessageDAO extends Spring implements DataAccessInterface<ChatMessage> {

	
	//function for fetching all messages from db
	@Override
	public List<ChatMessage> findAll() {

		//instantiate list of messages object
		List<ChatMessage> messages = new ArrayList<ChatMessage>();

		try {
			// select query
			String query = "SELECT * FROM MILESTONE.MESSAGES INNER JOIN MILESTONE.USERS ON MILESTONE.MESSAGES.USER_ID=MILESTONE.USERS.ID";

			SqlRowSet srs = jdbcTemplate.queryForRowSet(query);

			//loop through result set
			while (srs.next()) {
				int userId = srs.getInt("ID");
				int messageId = srs.getInt("MESSAGE_ID");
				String content = srs.getString("CONTENT");
				Date date = srs.getDate("CREATED_ON");
				String displayName = srs.getString("FIRST_NAME") + " " + srs.getString("LAST_NAME");

				//add new message object to list
				messages.add(new ChatMessage(messageId, userId, content, date, displayName));

			}

		} catch (Exception e) {
			e.printStackTrace();

		}
		//return list 
		return messages;
	}

	//function for finding specific message from db based on matching id
	@Override
	public ChatMessage findById(int id) {
		// TODO Auto-generated method stu

		String query = "SELECT * FROM MILESTONE.MESSAGES WHERE MESSAGE_ID = ?";

		ChatMessage message = new ChatMessage();

		try {
			SqlRowSet srs = jdbcTemplate.queryForRowSet(query, id);
	
			while (srs.next()) {
				int userId = srs.getInt("USER_ID");
				int messageId = srs.getInt("MESSAGE_ID");
				String content = srs.getString("CONTENT");
				Date date = srs.getDate("CREATED_ON");
				String displayName = "";
	
				message = (new ChatMessage(messageId, userId, content, date, displayName));
	
			}
	
			return message;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return message;
	}

	//function for creating new message in db
	@Override
	public boolean create(ChatMessage m) {

		try {
			String query = "INSERT INTO MILESTONE.MESSAGES (USER_ID, CONTENT, CREATED_ON)" + " values (?, ?, ?)";

			int result = jdbcTemplate.update(query, m.getUserId(), m.getContent(), m.getCreatedOn());

			return (result > 0);

		} catch (Exception e) {
			e.printStackTrace();			
		}
		return false;
	}

	//function for updating existing message in db
	@Override
	public boolean update(ChatMessage t) {
		// TODO Auto-generated method stub
		try {
			String query = "UPDATE MILESTONE.MESSAGES SET CONTENT = ? WHERE MESSAGE_ID = ?";
			int result = jdbcTemplate.update(query, t.getContent(), t.getId());
	
			return result > 0;
			
		} catch(Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	//function for deleting message in db
	@Override
	public boolean delete(ChatMessage t) {
		// TODO Auto-generated method stub
		try {

			String query = "DELETE FROM MILESTONE.MESSAGES WHERE MESSAGE_ID = ?";
	
			int result = jdbcTemplate.update(query, t.getId());
	
			return result > 0;
		} catch(Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public ChatMessage findBy(ChatMessage t) {
		// TODO Auto-generated method stub
		return null;
	}

}

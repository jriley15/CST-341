package com.gcu.data.tables;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.gcu.data.dto.ChatMessage;
import com.gcu.data.dto.LoginRequest;
import com.gcu.data.entity.Message;
import com.gcu.data.entity.User;

public class Messages extends Table implements IMessages {

	
	public Messages() {
		super();
	}
	
	
	
	@Override
	public boolean create(Message m) {
		
		//insert message

		try {
			//insert query
			String query = "INSERT INTO MILESTONE.MESSAGES (USER_ID, CONTENT, CREATED_ON)" + " values (?, ?, ?)";

			//prepared statement
			PreparedStatement preparedStmt = connection.prepareStatement(query);
			preparedStmt.setInt(1, m.getUserId());
			preparedStmt.setString(2, m.getContent());
			preparedStmt.setDate(3, m.getCreatedOn());

			//return rows affected from query
			int rowsAffected = preparedStmt.executeUpdate();
			
			//close statement
			preparedStmt.close();
			
			//return whether or not the row was inserted
			return rowsAffected > 0;

		} catch (Exception e) {
			e.printStackTrace();
		}

		//error, return false
		return false;
	}



	@Override
	public List<ChatMessage> getAll() {
		
		//get top 100 chat messages joined with user display names (message.userId join on users.ID)
		
		List<ChatMessage> messages = new ArrayList<ChatMessage>();
		
		//try catch
		try {

			
			//select query
			String query = "SELECT * FROM MILESTONE.MESSAGES INNER JOIN MILESTONE.USERS ON MILESTONE.MESSAGES.USER_ID=MILESTONE.USERS.ID";
			

			//prepared statement
			PreparedStatement preparedStmt = connection.prepareStatement(query);

			//get result set for query execution
			ResultSet rs = preparedStmt.executeQuery();
			
			//loop through results
			while (rs.next()) {
				
				int userId = rs.getInt("ID");
				int messageId = rs.getInt("MESSAGE_ID");
				String content = rs.getString("CONTENT");
				Date date = rs.getDate("CREATED_ON");
				String displayName = rs.getString("FIRST_NAME") + " "+rs.getString("LAST_NAME");
				
				
				messages.add(new ChatMessage(messageId, userId, content, date, displayName));
				//messages.add(new ChatMessage(messageId, 0, content, date, "Test"));

			}

			//close statement
			preparedStmt.close();
			

		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return messages;
	}



	
	
	
	
	
}

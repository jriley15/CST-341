package com.gcu.data;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import org.springframework.jdbc.support.rowset.SqlRowSet;

import com.gcu.data.entity.Message;
import com.gcu.data.entity.User;

public class UserDAO extends Spring implements DataAccessInterface<User> {

	@Override
	public List<User> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public User findById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean create(User u) {
		//inserts new user u into database
		
		String query = "INSERT INTO MILESTONE.USERS (EMAIL, PASSWORD, FIRST_NAME, LAST_NAME)" + " values (?, ?, ?, ?)";

		int result = jdbcTemplate.update(query, u.getEmail(), 
				u.getPassword(), 
				u.getFirstName(), 
				u.getLastName());

		
		return (result > 0);
		
		/*try {
			//insert query
			String query = "INSERT INTO MILESTONE.USERS (EMAIL, PASSWORD, FIRST_NAME, LAST_NAME)" + " values (?, ?, ?, ?)";

			//prepared statement
			PreparedStatement preparedStmt = connection.prepareStatement(query);
			preparedStmt.setString(1, u.getEmail());
			preparedStmt.setString(2, u.getPassword());
			preparedStmt.setString(3, u.getFirstName());
			preparedStmt.setString(4, u.getLastName());

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
		return false;*/

	}

	@Override
	public boolean update(User t) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean delete(User t) {
		// TODO Auto-generated method stub
		return false;
	}

	
	@Override
	public User findBy(User t) {
		// searches through users for existing email
		
		
		User user = null;
		
		String query = "SELECT * FROM MILESTONE.USERS WHERE EMAIL = ?";
		
		SqlRowSet srs = jdbcTemplate.queryForRowSet(query, t.getEmail());
		
		while(srs.next())
		{

			int id = srs.getInt("ID");
			String email = srs.getString("EMAIL");
			String pass = srs.getString("PASSWORD");
			String fn = srs.getString("FIRST_NAME");
			String ln = srs.getString("LAST_NAME");

			//set user object to new user loaded from db
			user = new User(id, fn, ln, email, pass);
	
		}
		
		return user;
		
		/*try {

			//select query
			String query = "SELECT * FROM MILESTONE.USERS WHERE EMAIL = ?";

			//prepared statement
			PreparedStatement preparedStmt = connection.prepareStatement(query);
			preparedStmt.setString(1, email);

			//get result set for query execution
			ResultSet rs = preparedStmt.executeQuery();
			
			//check if any results 
			if (rs.next()) {
				
				//email does exist, return true
				return true;
			}

			//close statement
			preparedStmt.close();
			

		} catch (Exception e) {
			e.printStackTrace();
		}
		
		//email doesn't exist
		return false;
		
		
		return null;*/
	}

	
	
	
	
	
}

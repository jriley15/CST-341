package com.gcu.data.tables;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import com.gcu.data.dto.LoginRequest;
import com.gcu.data.entity.User;


//users table class (inherits table class)
public class Users extends Table<User> {

	
	//constructor (call super class constructor and pass connection to it)
	public Users(Connection c) {
		super(c);
	}

	@Override
	public boolean create(User u) {

		// insert user to db

		try {
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
		return false;
	}

	@Override
	public ArrayList<User> getAll() {
		//not implemented yet
		return null;
	}

	@Override
	public User getOne(int id) {
		//not implemented yet
		return null;
	}

	@Override
	public boolean update(User e) {
		//not implemented yet
		return false;
	}

	@Override
	public boolean delete(int id) {
		//not implemented yet
		return false;
	}

	//validates a login request against the db
	public User validate(LoginRequest request) {

		//create null user object
		User user = null;
		
		//try catch
		try {

			//select query
			String query = "SELECT * FROM MILESTONE.USERS WHERE EMAIL = ? AND PASSWORD = ?";

			//prepared statement
			PreparedStatement preparedStmt = connection.prepareStatement(query);
			preparedStmt.setString(1, request.getEmail());
			preparedStmt.setString(2, request.getPassword());

			//get result set for query execution
			ResultSet rs = preparedStmt.executeQuery();
			
			//loop through results
			while (rs.next()) {

				int id = rs.getInt("ID");
				String email = rs.getString("EMAIL");
				String pass = rs.getString("PASSWORD");
				String fn = rs.getString("FIRST_NAME");
				String ln = rs.getString("LAST_NAME");

				//set user object to new user loaded from db
				user = new User(id, fn, ln, email, pass);

			}

			//close statement
			preparedStmt.close();
			

		} catch (Exception e) {
			e.printStackTrace();
		}
		
		//return user object (null if user wasn't found in db)

		return user;
	}

	
	public boolean emailExists(String email) {
		try {

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

	}

}

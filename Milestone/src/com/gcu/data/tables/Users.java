package com.gcu.data.tables;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import com.gcu.data.dto.LoginRequest;
import com.gcu.data.entity.User;

public class Users extends Table<User> {

	public Users(Connection c) {
		super(c);
	}

	@Override
	public boolean create(User u) {

		// insert user to db

		try {

			String query = "INSERT INTO MILESTONE.USERS (EMAIL, PASSWORD, FIRST_NAME, LAST_NAME)" + " values (?, ?, ?, ?)";

			PreparedStatement preparedStmt = connection.prepareStatement(query);
			preparedStmt.setString(1, u.getEmail());
			preparedStmt.setString(2, u.getPassword());
			preparedStmt.setString(3, u.getFirstName());
			preparedStmt.setString(4, u.getLastName());

			int rowsAffected = preparedStmt.executeUpdate();
			preparedStmt.close();
			
			return rowsAffected > 0;

		} catch (Exception e) {
			e.printStackTrace();
		}

		return false;
	}

	@Override
	public ArrayList<User> getAll() {

		// return list of all users

		return null;
	}

	@Override
	public User getOne(int id) {

		return null;
	}

	@Override
	public boolean update(User e) {

		return false;
	}

	@Override
	public boolean delete(int id) {

		return false;
	}

	public User validate(LoginRequest request) {

		User user = null;
		

		try {

			String query = "SELECT * FROM MILESTONE.USERS WHERE EMAIL = ? AND PASSWORD = ?";

			PreparedStatement preparedStmt = connection.prepareStatement(query);
			preparedStmt.setString(1, request.getEmail());
			preparedStmt.setString(2, request.getPassword());

			ResultSet rs = preparedStmt.executeQuery();
			while (rs.next()) {

				int id = rs.getInt("ID");
				String email = rs.getString("EMAIL");
				String pass = rs.getString("PASSWORD");
				String fn = rs.getString("FIRST_NAME");
				String ln = rs.getString("LAST_NAME");

				user = new User(id, fn, ln, email, pass);

			}
			
			
			
			preparedStmt.close();
			

		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		

		return user;
	}

	public boolean emailExists(String email) {

		return false;

	}

}

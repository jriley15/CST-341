package com.gcu.services;

import com.gcu.data.DatabaseContext;
import com.gcu.data.dto.LoginRequest;
import com.gcu.data.dto.RegisterRequest;
import com.gcu.data.entity.User;

public class UserService {

	
	DatabaseContext dbContext;

	public UserService() {

		dbContext = new DatabaseContext();
		
	}

	public int Register(RegisterRequest request) {
		
		//check if email already exists in db
		
		//hardcoded check to approve regsitration
		if (request.getEmail().equalsIgnoreCase("admin@gcu.edu")) {
			return 0;
		}
		return 1;
	}
	
	
	public User Login(LoginRequest request) {
		
		User user = null;
		
		dbContext.users.create(null);
		
		//hardcoded user for login approval
		if (request.getEmail().equalsIgnoreCase("admin@gcu.edu") && request.getPassword().equalsIgnoreCase("password")) {		
			user = new User(0, "", "", request.getEmail(), request.getPassword());
		}
		return user;
	}
	

	
}

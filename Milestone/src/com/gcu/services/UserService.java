package com.gcu.services;

import com.gcu.data.DatabaseContext;
import com.gcu.data.dto.LoginRequest;
import com.gcu.data.dto.RegisterRequest;
import com.gcu.data.entity.User;

public class UserService extends Service {


	public UserService() {

		super();
		
	}

	public int Register(RegisterRequest request) {
		
		//check if email already exists in db
		if (!dbContext.users.emailExists(request.getEmail())) {
			
			User user = new User(0, request.getFirstName(), request.getLastName(), request.getEmail(), request.getPassword());
			
			//insert user
			boolean created = dbContext.users.create(user);
			
			//close connection
			dbContext.close();
			
			if (created) {
				
				//success
				return 0;
			}
			
			//error inserting
			return 2;
			
		}
		
		
		return 1;
	}
	
	
	public User Login(LoginRequest request) {
		
		User user = dbContext.users.validate(request);
		dbContext.close();
		
		return user;
		
	}
	
	
	

	
}

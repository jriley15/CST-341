package com.gcu.services;

import com.gcu.data.DatabaseContext;
import com.gcu.data.dto.LoginRequest;
import com.gcu.data.dto.RegisterRequest;
import com.gcu.data.entity.User;


//user service class
public class UserService extends Service implements IUserService {


	public UserService() {

		super();
		
	}

	//register function
	public int Register(RegisterRequest request) {
		
		//check if email already exists in db
		if (!dbContext.getUsers().emailExists(request.getEmail())) {
			
			//create user object entity 
			User user = new User(0, request.getFirstName(), request.getLastName(), request.getEmail(), request.getPassword());
			
			//insert user
			boolean created = dbContext.getUsers().create(user);
			
			//close connection
			//dbContext.close();
			
			if (created) {
				//success
				return 0;
			}
			
			//error inserting
			return 2;
			
		}
		
		//email exists
		return 1;
	}
	
	//login function
	public User Login(LoginRequest request) {
		
		//attempt to find user in db with user/pass
		User user = dbContext.getUsers().validate(request);
		
		//close db
		//dbContext.close();
		
		
		//return user object (null if didn't find)
		return user;
		
	}
	
	
	

	
}

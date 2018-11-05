package com.gcu.services;

import org.springframework.beans.factory.annotation.Autowired;

import com.gcu.data.DataAccessInterface;
import com.gcu.data.dto.LoginRequest;
import com.gcu.data.dto.RegisterRequest;
import com.gcu.data.entity.Message;
import com.gcu.data.entity.User;


//user service class
public class UserService implements IUserService {


	
	private DataAccessInterface<User> userDAO;
	
	
	
	//register function
	public int Register(RegisterRequest request) {
		
		//create user object entity 
		User user = new User(0, request.getFirstName(), request.getLastName(), request.getEmail(), request.getPassword());
		
		//check if email already exists in db
		if (userDAO.findBy(user) == null) {
			
			//insert user
			boolean created = userDAO.create(user);
			
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
		
		User user = new User(0, null, null, request.getEmail(), request.getPassword());
		
		
		//attempt to find user in db with user/pass
		user = userDAO.findBy(user);
		
		if (user == null || !user.getPassword().equalsIgnoreCase(request.getPassword())) {
			user = null;
		}
		
		//close db
		//dbContext.close();
		
		
		//return user object (null if didn't find)
		return user;
		
	}
	
	
	
	@Autowired
	public void setUserDAO(DataAccessInterface<User> service) {
		userDAO = service;
	}


	
	
	

	
}

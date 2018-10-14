package com.gcu.services;

import com.gcu.data.dto.LoginRequest;
import com.gcu.data.dto.RegisterRequest;
import com.gcu.data.entity.User;

public interface IUserService {

	
		//register function
		public int Register(RegisterRequest request);
		
		//login function
		public User Login(LoginRequest request);
		

	
	
	
}

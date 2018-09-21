package com.gcu.controller;

import java.util.ArrayList;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.gcu.data.dto.Home;
import com.gcu.data.dto.LoginRequest;
import com.gcu.data.dto.RegisterRequest;
import com.gcu.data.entity.User;
import com.gcu.services.UserService;


@Controller 
@RequestMapping("/user")
public class UserController {

	public UserService userService;
	
	public UserController() {
		userService = new UserService();
	}
	
	
	@RequestMapping(path = "/register", method = RequestMethod.GET) 
	public ModelAndView displayRegisterForm() {
		
		return new ModelAndView("register", "request", new RegisterRequest());
	}
	
	@RequestMapping(path = "/doRegister", method = RequestMethod.POST) 
	public ModelAndView doRegister(@Valid @ModelAttribute("request") RegisterRequest request, BindingResult result) {
		
		if (!result.hasErrors()) {
			
			//call user service for further validation and account creation
			int response = userService.Register(request);
			
			if (response == 0) {
				
				//return success view
				return new ModelAndView("home", "model", new Home("Successfully registered"));
	
			} else if (response == 1) {
				
				ObjectError error = new ObjectError("email","Email already in use");
				result.addError(error);
				
			} else if (response == 2) {
				
				ObjectError error = new ObjectError("*","Error creating user");
				result.addError(error);
				
			}
		}
		
		//return registration view with errors
		return new ModelAndView("register", "request", request);
	}
	
	
	@RequestMapping(path = "/login", method = RequestMethod.GET) 
	public ModelAndView displayLoginForm() {
		
		return new ModelAndView("login", "request", new LoginRequest());
	}
	
	@RequestMapping(path = "/doLogin", method = RequestMethod.POST) 
	public ModelAndView doLogin(@Valid @ModelAttribute("request") LoginRequest request, BindingResult result) {
		
		if (!result.hasErrors()) {
			
			//call user service for further validation and account creation
			User user = userService.Login(request);
			if (user != null) {
				
				//return success view
				return new ModelAndView("home", "model", new Home("Successfully logged in"));
				
			} else {
				
				ObjectError error = new ObjectError("*","Invalid username or password");
				result.addError(error);
			}
			
		}
		
		//return login view with errors
		return new ModelAndView("login", "request", request);
	}
	
	
	
}

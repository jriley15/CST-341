package com.gcu.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.gcu.data.dto.Home;


//home default controller route
@Controller 
@RequestMapping("/")
public class HomeController {

	
	
	//default end point
	/**
	 * @return
	 */
	@RequestMapping("*")
	public ModelAndView displayHomeView() {
		
		//return home view with new blank home view model
		return new ModelAndView("home", "model", new Home());
	    
	}

	
}





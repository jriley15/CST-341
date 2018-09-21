package com.gcu.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.gcu.data.dto.Home;

@Controller 
@RequestMapping("/")
public class HomeController {

	
	@RequestMapping("*")
	public ModelAndView displayHomeView() {
		
		
		
		return new ModelAndView("home", "model", new Home());
	    
	    
	}
	
	
	
	
}

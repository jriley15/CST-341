package com.gcu.services;

import com.gcu.data.DatabaseContext;

//service parent class
public class Service {

	
	//db context
	protected DatabaseContext dbContext;

	
	public Service() {

		
		//instantiate new db context
		dbContext = new DatabaseContext();
		
	}

	
}

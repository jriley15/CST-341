package com.gcu.services;

import org.springframework.beans.factory.annotation.Autowired;

import com.gcu.data.DatabaseContext;
import com.gcu.data.IDatabaseContext;

//service parent class
public class Service {

	
	//db context
	protected IDatabaseContext dbContext;

	
	public Service() {

	}
	
	@Autowired
	public void setdbContext(IDatabaseContext dbContext) {
		this.dbContext = dbContext;
	}

	
}

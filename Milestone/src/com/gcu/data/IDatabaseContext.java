package com.gcu.data;

import java.sql.Connection;
import java.sql.DriverManager;

import com.gcu.data.entity.User;
import com.gcu.data.tables.IMessages;
import com.gcu.data.tables.IUsers;
import com.gcu.data.tables.Table;
import com.gcu.data.tables.Users;

//db context class (resembles complete database object for services to use)
public interface IDatabaseContext {


	public void close() ;
	
	
	public IUsers getUsers();
	
	public IMessages getMessages();
	
}

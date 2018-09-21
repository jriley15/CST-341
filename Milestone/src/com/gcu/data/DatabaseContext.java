package com.gcu.data;

import java.sql.Connection;
import java.sql.DriverManager;

import com.gcu.data.entity.User;
import com.gcu.data.tables.Table;
import com.gcu.data.tables.Users;

public class DatabaseContext {

	//jdbc driver
	static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
	
	
	//sql server credentials
	private static final String server = "";
	private static final String username = "";
	private static final String password = "";
	
	
	//sql connection
	private Connection connection;
	
	//tables
	public Table<User> users;


	public DatabaseContext() {

		//create connection
		 try {
		      //STEP 2: Register JDBC driver
		      Class.forName(JDBC_DRIVER);

		      //STEP 3: Open a connection
		      connection = DriverManager.getConnection(server, username, password);

		
		      users = new Users(connection);
		
		 } catch (Exception e) {
			 e.printStackTrace();
		 }


	}
	
	
	
	
	
	
	
	
	
	
}

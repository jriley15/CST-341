package com.gcu.data;

import java.sql.Connection;
import java.sql.DriverManager;

import com.gcu.data.entity.User;
import com.gcu.data.tables.Table;
import com.gcu.data.tables.Users;

public class DatabaseContext {

	
	//db url
	private static final String server = "jdbc:derby:C:/Users/Jordan/MyDB;user=admin;password=password";

	//db connection
	private Connection connection;
	
	//tables
	public Users users;


	public DatabaseContext() {

		//create connection
		 try {
		      //STEP 2: Register JDBC driver
			 	Class.forName("org.apache.derby.jdbc.EmbeddedDriver").newInstance();

		      //STEP 3: Open a connection
		      connection = DriverManager.getConnection(server);

		
		      users = new Users(connection);
		      
		
		 } catch (Exception e) {
			 e.printStackTrace();
		 }
	}
	
	public void close() {
		
		try {
			this.connection.close();
		} catch (Exception e) {
			
		}
	}
	
	
}

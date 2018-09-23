package com.gcu.data;

import java.sql.Connection;
import java.sql.DriverManager;

import com.gcu.data.entity.User;
import com.gcu.data.tables.Table;
import com.gcu.data.tables.Users;

//db context class (resembles complete database object for services to use)
public class DatabaseContext {

	
	//db url
	private static final String server = "jdbc:derby:C:/Users/Jordan/MyDB;user=admin;password=password";

	//db connection
	private Connection connection;
	
	//tables
	public Users users;

	//constructor
	public DatabaseContext() {

		//try catch 
		 try {
		      //Register JDBC driver
			 	Class.forName("org.apache.derby.jdbc.EmbeddedDriver").newInstance();

		      //Open a connection
		      connection = DriverManager.getConnection(server);

		      //instantiate users table with db connection param
		      users = new Users(connection);
		      
		      
		
		 } catch (Exception e) {
			 e.printStackTrace();
		 }
	}
	
	//function to close connection
	public void close() {
		
		try {
			this.connection.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
}

package com.gcu.data;

import java.sql.Connection;
import java.sql.DriverManager;

import org.springframework.beans.factory.annotation.Autowired;

import com.gcu.data.entity.User;
import com.gcu.data.tables.IMessages;
import com.gcu.data.tables.IUsers;
import com.gcu.data.tables.Table;
import com.gcu.data.tables.Users;

//db context class (resembles complete database object for services to use)
public class DatabaseContext implements IDatabaseContext {

	
	//db url
	private static final String server = "jdbc:derby:C:/Users/Jordan/MyDB;user=admin;password=password";

	//db connection
	private Connection connection;
	
	//tables
	public IUsers users;
	public IMessages messages;

	//constructor
	public DatabaseContext() {

		//try catch 
		 try {
		      //Register JDBC driver
			 	Class.forName("org.apache.derby.jdbc.EmbeddedDriver").newInstance();

		      //Open a connection
		      connection = DriverManager.getConnection(server);

		      //instantiate users table with db connection param
		      //users = new Users(connection);
		      
		      
		
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
	
	@Autowired
	public void setUsers(IUsers users) {
		this.users = users;
		this.users.setConnection(connection);
	}
	
	@Autowired
	public void setMessages(IMessages messages) {
		this.messages = messages;
		this.messages.setConnection(connection);
	}
	
	public IUsers getUsers() {
		return this.users;
	}

	public IMessages getMessages() {
		return this.messages;
	}
	
}

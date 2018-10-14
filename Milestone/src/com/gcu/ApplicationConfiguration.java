package com.gcu;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;

import com.gcu.controller.ChatController;
import com.gcu.controller.HomeController;
import com.gcu.controller.UserController;
import com.gcu.data.DatabaseContext;
import com.gcu.data.IDatabaseContext;
import com.gcu.data.tables.IMessages;
import com.gcu.data.tables.IUsers;
import com.gcu.data.tables.Messages;
import com.gcu.data.tables.Users;
import com.gcu.services.ChatService;
import com.gcu.services.IChatService;
import com.gcu.services.IUserService;
import com.gcu.services.UserService;

@Configuration 
public class ApplicationConfiguration {

	
	/*
	 * 
	 * Controllers
	 * 
	 */
	
	@Bean(name="userController") 
	public UserController getUserController() {
		return new UserController();
	}
	
	@Bean(name="homeController") 
	public HomeController getHomeController() {
		return new HomeController();
	}
	
	@Bean(name="chatController") 
	public ChatController getChatController() {
		return new ChatController();
	}
	
	
	
	/*
	 * Services
	 * 
	 */
	
	@Bean(name="userService")
	@Scope(value="request", proxyMode=ScopedProxyMode.TARGET_CLASS)
	public IUserService getUserService() {
		
		return new UserService();

	}
	
	@Bean(name="chatService")
	@Scope(value="request", proxyMode=ScopedProxyMode.TARGET_CLASS)
	public IChatService getChatService() {
		
		return new ChatService();

	}
	
	/*
	 * 
	 * Database access
	 * 
	 */
	
	@Bean(name="dbContext")
	@Scope(value="request", proxyMode=ScopedProxyMode.TARGET_CLASS)
	public IDatabaseContext getdbContext() {
		
		return new DatabaseContext();

	}
	
	@Bean(name="usersTable")
	@Scope(value="request", proxyMode=ScopedProxyMode.TARGET_CLASS)
	public IUsers getUsersTable() {
		
		return new Users();

	}
	
	@Bean(name="messagesTable")
	@Scope(value="request", proxyMode=ScopedProxyMode.TARGET_CLASS)
	public IMessages getMessagesTable() {
		
		return new Messages();

	}
	
}

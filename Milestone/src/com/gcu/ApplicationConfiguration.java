package com.gcu;

import org.apache.tomcat.jdbc.pool.DataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;

import com.gcu.controller.ChatController;
import com.gcu.controller.HomeController;
import com.gcu.controller.UserController;
import com.gcu.data.DataAccessInterface;
import com.gcu.data.MessageDAO;
import com.gcu.data.UserDAO;
import com.gcu.data.dto.ChatMessage;
import com.gcu.data.entity.Message;
import com.gcu.data.entity.User;
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
	@Scope(value="singleton", proxyMode=ScopedProxyMode.TARGET_CLASS)
	public IUserService getUserService() {
		
		return new UserService();

	}
	
	@Bean(name="chatService")
	@Scope(value="singleton", proxyMode=ScopedProxyMode.TARGET_CLASS)
	public IChatService getChatService() {
		
		return new ChatService();

	}
	
	/*
	 * 
	 * Database access
	 * 
	 */
	
	
	@Bean(name="userDAO")
	@Scope(value="singleton", proxyMode=ScopedProxyMode.TARGET_CLASS)
	public DataAccessInterface<User> getUserDAO() {
		
		return new UserDAO();

	}
	
	@Bean(name="messageDAO")
	@Scope(value="singleton", proxyMode=ScopedProxyMode.TARGET_CLASS)
	public DataAccessInterface<ChatMessage> getMessageDAO() {
		
		return new MessageDAO();

	}
	
	
	/*
	 * 
	 * Spring JDBC config
	 * 
	 */
	
	@Bean(name="dataSource", destroyMethod = "close")
	@Scope(value="singleton", proxyMode=ScopedProxyMode.TARGET_CLASS)
	public DataSource getDataSource()
	{
		DataSource dataSource = new DataSource(); // org.apache.tomcat.jdbc.pool.DataSource;
	    dataSource.setDriverClassName("org.apache.derby.jdbc.EmbeddedDriver");
	    dataSource.setUrl("jdbc:derby:C:/Users/Jordan/MyDB");
	    dataSource.setUsername("admin");
	    dataSource.setPassword("password"); 
	    return dataSource;
	}
	
	
	
	
}

package com.gcu.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.gcu.data.dto.ChatMessage;
import com.gcu.data.dto.EditMessageRequest;
import com.gcu.data.dto.Home;
import com.gcu.data.dto.LoginRequest;
import com.gcu.data.dto.SendMessageRequest;
import com.gcu.data.entity.User;
import com.gcu.services.IChatService;
import com.gcu.services.IUserService;


@Controller 
@RequestMapping("/chat")
public class ChatController {

	public IChatService chatService;
	

	public ChatController() {
		
	}

	//chat view end point
	
	@RequestMapping(path = "", method = RequestMethod.GET) 
	public ModelAndView chat(HttpSession session) {
		
		return displayChat(session);
	}
	

	@RequestMapping(path = "*", method = RequestMethod.GET) 
	public ModelAndView displayChat(HttpSession session) {
		
		//load and verify user is logged in from session
		//load all chat messages to list
		//send chatview model back with messages

		User user = (User) session.getAttribute("user");
		
		ModelAndView model = new ModelAndView();
		model.setViewName("chat"); 
		
		if (user != null) {

			model.addObject("messages", chatService.getMessages());
			model.addObject("sendMessageRequest", new SendMessageRequest());
		
		} else {
			
			List<String> errors = new ArrayList<String>();
			errors.add("You must be logged in to view this page.");
			model.addObject("errors", errors);
			
		}
		
		return model;
	}
	
	//send message post action
	@RequestMapping(path = "/sendMessage", method = RequestMethod.POST) 
	public ModelAndView sendMessage(@Valid @ModelAttribute("sendMessageRequest") SendMessageRequest request, BindingResult result, HttpSession session) {
		
		User user = (User) session.getAttribute("user");
		
		ModelAndView model = new ModelAndView();
		model.setViewName("chat"); 
		
		//check if user is logged in
		if (user != null) {
			
			//check for validation errors
			if (!result.hasErrors()) {
				
				//add new request model to view model
				model.addObject("sendMessageRequest", new SendMessageRequest());
				
				//attempt to create message
				if (!chatService.createMessage(user, request)) {

					//failure, add error to view model
					ObjectError error = new ObjectError("*","Error sending message");
					result.addError(error);
				}
			} else {
				
				//set viewmodel request to the original request that was passed in
				model.addObject("sendMessageRequest", request);
			}
			
			//add messages list to view model
			model.addObject("messages", chatService.getMessages());
		} else {
			//user isn't logged in, display error
			List<String> errors = new ArrayList<String>();
			errors.add("You must be logged in to view this page.");
			model.addObject("errors", errors);
		}

		//return chat view with errors
		return model;
	}
	
	@RequestMapping(path = "deleteMessage", method = RequestMethod.GET) 
	public ModelAndView deleteMessage(@RequestParam("messageId") int messageId, HttpSession session) {
	
		//fetch user from session
		User user = (User) session.getAttribute("user");
		
		//create new model and view instance
		ModelAndView model = new ModelAndView();
		model.setViewName("chat"); 
		
		//check if user is logged in
		if (user != null) {
			
			//delete message
			if (chatService.deleteMessage(user, messageId)) {
				//success, return chat display with messages
				return displayChat(session);
			}
			
			//failure, add errors to view model
			List<String> errors = new ArrayList<String>();
			errors.add("Error deleting message.");
			model.addObject("errors", errors);
			
		} else {
			//user isn't logged in
			List<String> errors = new ArrayList<String>();
			errors.add("You must be logged in to view this page.");
			model.addObject("errors", errors);	
		}
		
		//return view model
		return model;	
	}
	
	@RequestMapping(path = "viewMessage", method = RequestMethod.GET) 
	public ModelAndView viewMessage(@RequestParam("messageId") int messageId, HttpSession session) {
	
		//get user object from session
		User user = (User) session.getAttribute("user");
		
		ModelAndView model = new ModelAndView();
		model.setViewName("editMessage"); 
		
		//check if user is logged in
		if (user != null) {
			
			//get message from database
			ChatMessage message = chatService.getMessage(user, messageId);
			
			//check if message was loaded successfully 
			if (message != null) {

				//create new edit message request model and add it to the view model
				EditMessageRequest editMessageRequest = new EditMessageRequest(messageId, message.getContent());				
				model.addObject("editMessageRequest", editMessageRequest);
			} else {
				//message wasn't loaded correctly 
				List<String> errors = new ArrayList<String>();
				errors.add("Error viewing message.");
				model.addObject("errors", errors);
			}
			
		} else {
			//user isn't logged in
			List<String> errors = new ArrayList<String>();
			errors.add("You must be logged in to view this page.");
			model.addObject("errors", errors);
		}
		
		//return view model
		return model;
	}
	
	
	@RequestMapping(path = "/editMessage", method = RequestMethod.POST) 
	public ModelAndView editMessage(@Valid @ModelAttribute("editMessageRequest") EditMessageRequest request, BindingResult result, HttpSession session) {
		
		User user = (User) session.getAttribute("user");
		
		ModelAndView model = new ModelAndView();
		model.setViewName("chat"); 
		
		if (user != null) {
			
			//check for validation errors
			if (!result.hasErrors()) {
				
				model.addObject("sendMessageRequest", new SendMessageRequest());
				
				if (!chatService.editMessage(user, request)) {

					ObjectError error = new ObjectError("*","Error saving message");
					result.addError(error);
				}
			} else {
				model.addObject("sendMessageRequest", request);
			}
			
			model.addObject("messages", chatService.getMessages());
		} else {
			List<String> errors = new ArrayList<String>();
			errors.add("You must be logged in to view this page.");
			model.addObject("errors", errors);
		}

		//return login view with errors
		return model;
	}
	
	
	@Autowired
	public void setChatService(IChatService chatService) {
		this.chatService = chatService;
	}
	
}

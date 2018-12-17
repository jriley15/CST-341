package com.gcu.controller;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import com.gcu.data.dto.Home;
import com.gcu.data.dto.LoginRequest;
import com.gcu.data.dto.RegisterRequest;
import com.gcu.data.entity.User;
import com.gcu.services.IUserService;
import com.gcu.services.UserService;

@Controller
@RequestMapping("/user")
public class UserController {

	public IUserService userService;

	public UserController() {

	}

	// register view end point
	/**
	 * @return
	 */
	@RequestMapping(path = "/register", method = RequestMethod.GET)
	public ModelAndView displayRegisterForm() {

		return new ModelAndView("register", "request", new RegisterRequest());
	}

	// doRegister post action end point
	/**
	 * @param request
	 * @param result
	 * @return
	 */
	@RequestMapping(path = "/doRegister", method = RequestMethod.POST)
	public ModelAndView doRegister(@Valid @ModelAttribute("request") RegisterRequest request, BindingResult result) {

		// check if there are validation errors
		if (!result.hasErrors()) {

			// call user service for further validation and account creation
			int response = userService.register(request);

			// success
			if (response == 0) {

				// return success view
				return new ModelAndView("home", "model", new Home("Successfully registered"));

				// email in use
			} else if (response == 1) {

				ObjectError error = new ObjectError("*", "Email already in use");
				result.addError(error);

				// db insert error
			} else if (response == 2) {

				ObjectError error = new ObjectError("*", "Error creating user");
				result.addError(error);

			}
		}

		// return registration view with errors
		return new ModelAndView("register", "request", request);
	}

	// login view end point
	/**
	 * @return
	 */
	@RequestMapping(path = "/login", method = RequestMethod.GET)
	public ModelAndView displayLoginForm() {

		return new ModelAndView("login", "request", new LoginRequest());
	}

	// do login post action end point
	/**
	 * @param request
	 * @param result
	 * @param session
	 * @return
	 */
	@RequestMapping(path = "/doLogin", method = RequestMethod.POST)
	public ModelAndView doLogin(@Valid @ModelAttribute("request") LoginRequest request, BindingResult result,
			HttpSession session) {

		// check for validation errors
		if (!result.hasErrors()) {

			// call user service for further validation and account creation
			User user = userService.login(request);
			if (user != null) {

				// store user object in session
				session.setAttribute("user", user);

				// return success view
				return new ModelAndView("home", "model",
						new Home("Successfully logged in as: [" + user.getId() + "] - " + user.getEmail()));

				// invalid user/pass
			} else {

				ObjectError error = new ObjectError("*", "Invalid username or password");
				result.addError(error);
			}

		}

		// return login view with errors
		return new ModelAndView("login", "request", request);
	}

	// logout route
	/**
	 * @param session
	 * @return
	 */
	@RequestMapping(path = "/logout", method = RequestMethod.GET)
	public String logout(HttpSession session) {

		// clear session
		session.invalidate();

		// redirect to login page
		return "redirect:/login";
	}

	/**
	 * @param userService
	 */
	@Autowired
	public void setUserService(IUserService userService) {
		this.userService = userService;
	}

}

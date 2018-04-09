package com.revature.rest;

import static com.revature.util.ClientMessageUtil.REGISTRATION_SUCCESSFUL;
import static com.revature.util.ClientMessageUtil.SOMETHING_WRONG;
import static com.revature.util.ClientMessageUtil.INVALID_LOGIN;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import com.revature.ajax.ClientMessage;
import com.revature.model.User;
import com.revature.service.UserService;

@Controller("userController")
public class UserControllerAlpha implements UserController {
	private static Logger logger = Logger.getLogger(UserControllerAlpha.class);
	
	
	@Autowired
	private UserService userService;
	
	@Override
	@PostMapping(value="/registerUser")
	public @ResponseBody ClientMessage registerUser(@RequestBody User user) {
		logger.trace("Registering user: " + user);
		return (userService.registerUser(user) ? REGISTRATION_SUCCESSFUL : SOMETHING_WRONG);
	}

	@Override
	@PostMapping(value="/login")
	public @ResponseBody Object login(@RequestBody User user) {
		logger.trace("Validating input: " + user);
		if(user == null 
				|| user.getPassword() == null || user.getPassword().equals("") 
				|| user.getUsername() == null || user.getUsername().equals("")) {
			return INVALID_LOGIN;
		} else {
			User loggedUser = userService.authenticate(user);
			if(loggedUser != null) {
				return loggedUser;
			} else {
				return INVALID_LOGIN;
			}
		}
	}

}

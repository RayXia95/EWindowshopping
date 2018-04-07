package com.revature.rest;

import static com.revature.util.ClientMessageUtil.REGISTRATION_SUCCESSFUL;
import static com.revature.util.ClientMessageUtil.SOMETHING_WRONG;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;

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
	public ClientMessage registerUser(User user) {
		logger.trace("Registering user: " + user);
		return (userService.registerUser(user) ? REGISTRATION_SUCCESSFUL : SOMETHING_WRONG);
	}

}

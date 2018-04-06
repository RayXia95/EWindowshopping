package com.revature.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;

import com.revature.ajax.ClientMessage;
import com.revature.model.User;
import com.revature.service.UserService;

@Controller("userController")
public class UserControllerAlpha implements UserController {

	@Autowired
	private UserService userService;
	
	@Override
	@PostMapping(value="/registerUser")
	public ClientMessage registerUser(User user) {
		// TODO Auto-generated method stub
		return null;
	}

}

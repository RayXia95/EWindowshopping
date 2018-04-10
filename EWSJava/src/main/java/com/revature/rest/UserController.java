package com.revature.rest;

import com.revature.ajax.ClientMessage;
import com.revature.model.User;

public interface UserController {
	ClientMessage registerUser(User user);
	Object login(User user);
}

package com.revature.service;

import org.springframework.beans.factory.annotation.Autowired;

import com.revature.model.User;
import com.revature.repository.UserRepository;

public class UserServiceAlpha implements UserService {

	@Autowired
	UserRepository userRepository;
	
	@Override
	public boolean registerUser(User user) {
		userRepository.save(user);
		return (user.getId() != 0);
	}

}

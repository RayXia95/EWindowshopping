package com.revature.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.revature.model.User;
import com.revature.repository.UserRepository;

@Service("userService")
public class UserServiceAlpha implements UserService {

	@Autowired
	UserRepository userRepository;
	
	@Override
	public boolean registerUser(User user) {
		userRepository.save(user);
		return (user.getId() != 0);
	}

}

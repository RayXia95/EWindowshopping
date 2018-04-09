package com.revature.service;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.revature.model.User;
import com.revature.repository.UserRepository;
import com.revature.repository.UserRepositoryHibernate;

@Service("userService")
public class UserServiceAlpha implements UserService {

	private static Logger logger = Logger.getLogger(UserServiceAlpha.class);
	
	@Autowired
	UserRepository userRepository;
	
	@Override
	public boolean registerUser(User user) {
		user.setPassword(new Integer(user.getPassword().hashCode()).toString());
		userRepository.save(user);
		return (user.getId() != 0);
	}

	@Override
	public User authenticate(User user) {
		User loggedUser = userRepository.select(user.getUsername());
		if(loggedUser != null && loggedUser.getPassword().equals(new Integer(user.getPassword().hashCode()).toString())) {
			logger.trace("Authentication of user: " + user.getUsername() + " successful");
			return loggedUser;
		}
		logger.trace("Authentication Failure");
		return null;
	}

}

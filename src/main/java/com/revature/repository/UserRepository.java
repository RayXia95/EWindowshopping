package com.revature.repository;

import com.revature.model.User;

public interface UserRepository {
	void save(User user);
	User select(String username);
}

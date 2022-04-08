package com.hello.service;

import java.sql.SQLException;
import java.util.List;

import com.hello.model.User;

import com.hello.repository.UserRepository;

public class UserService {
	private UserRepository userRepository;

	public UserService() {
		userRepository = new UserRepository();
	}

	public UserRepository getUserRepository() {
		return userRepository;
	}

	public void setUserRepository(UserRepository userRepository) {
		this.userRepository = userRepository;
	}

	public int saveUser(User user) {
		try {
			return userRepository.registerUser(user);
		} catch (Exception ex) {
			return -1;
		}
	}


	public User getUserByName(String name) throws SQLException, Exception {
		return userRepository.getUsertByName(name);
	}

	public List<User> getListUser() throws SQLException, Exception {
		return userRepository.getAllUser();
	}
}

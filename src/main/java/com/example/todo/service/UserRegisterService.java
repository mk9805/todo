package com.example.todo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.todo.domain.User;
import com.example.todo.mapper.UserMapper;

@Service
public class UserRegisterService {

	@Autowired
	private UserMapper mapper;
	
	public void createUser(User user) {
		mapper.createUser(user);
	}
	
	public boolean isDupplicateUsername(String username) {
		User user = mapper.identifyUser(username);
		return user != null;
	}
}

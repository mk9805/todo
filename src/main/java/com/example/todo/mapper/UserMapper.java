package com.example.todo.mapper;

import org.apache.ibatis.annotations.Mapper;

import com.example.todo.domain.User;

@Mapper
public interface UserMapper {
	public User identifyUser(String username);

	public void createUser(User user);
}



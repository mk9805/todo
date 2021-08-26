package com.example.todo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.example.todo.domain.User;
import com.example.todo.mapper.UserMapper;

@Service
public class UserDetailServiceImpl implements UserDetailsService {

	@Autowired
	private UserMapper mapper;
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		User user = mapper.identifyUser(username);
		if(user==null) {
			throw new UsernameNotFoundException(username);
			
		}
		return user;
	}

}

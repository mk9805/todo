package com.example.todo.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestAttribute;

import com.example.todo.domain.User;
import com.example.todo.service.UserRegisterService;

@Controller
public class UserController {

	@Autowired
	  private UserRegisterService userRegisterService;
	  
	  @Autowired
	  private PasswordEncoder passwordEncoder;
	  
	  @GetMapping("/login")
	  public String login() {
		  return "login";
	  }
	  
	  @GetMapping("/register")
	  public String register(Model model) {
		  model.addAttribute("user",new User());
		  return "register";
	  }
	  @PostMapping("/register")
	  public String createAccount(@Validated User user, BindingResult result,Model model) {
		  
		  if(result.hasErrors()) {
			  return "register";
		  }
		  
		  if(userRegisterService.isDupplicateUsername(user.getUsername())) {
			  model.addAttribute("isDupplicated","このユーザー名は既に登録されています");
			  return "register";
		  }
		  
		  User form = new User();
		  form.setUsername(user.getUsername());
		  form.setPassword(passwordEncoder.encode(user.getPassword()));
		  userRegisterService.createUser(form);
		  
		  return "login";
	  }
	  @PostMapping("/login-error")
	  public String onError(@RequestAttribute("SPRING_SECURITY_LAST_EXCEPTION") 
	  						AuthenticationException ex,
			  				Model model) {
		 model.addAttribute("authenticationException",ex);
		 return "login";
	  }
}

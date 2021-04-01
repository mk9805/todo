package com.example.todo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.todo.domain.Todo;
import com.example.todo.service.TodoService;


@Controller
public class createController {

  @Autowired
  private TodoService todoService;
  
  @GetMapping(value="/todo/add")
  public String getAdd(Model model,@ModelAttribute Todo todo) {
    return "todo/add";
  }
  @PostMapping(value="/todo/add")
  public String addTodo(@ModelAttribute Todo todo) {
    todoService.insert(todo);
    return "redirect:/todo";
  }
}

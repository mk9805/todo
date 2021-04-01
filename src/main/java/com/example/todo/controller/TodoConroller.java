package com.example.todo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.todo.domain.Todo;
import com.example.todo.service.TodoService;


@Controller
public class TodoConroller {

  @Autowired
  private TodoService todoService;
  
  @RequestMapping(value="/todo")
  public String index(Model model) {
    List<Todo> list =todoService.searchAll();
    model.addAttribute("todos", list);
    return "index";
  }

}

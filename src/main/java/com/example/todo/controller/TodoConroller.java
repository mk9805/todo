package com.example.todo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.todo.domain.Todo;
import com.example.todo.service.TodoService;

@RequestMapping(value = "/todo")
@Controller
public class TodoConroller {

  @Autowired
  private TodoService service;

  /**
   * 一覧表示
   * @param model
   * @return
   */
  @GetMapping
  public String index(Model model) {
	List<Todo> todos = service.searchAll();
    model.addAttribute("todos",todos);
    
    System.out.println(todos);
    return "index";
  }


  /**
   * 追加画面の表示
   * @param model
   * @param todo
   * @return
   */
  @GetMapping(value = "/add")
  public String getAdd(Model model) {
	model.addAttribute("todo", new Todo());
    return "todo/add";
  }

  
  /**
   * データの追加
   * @param todo
   * @param result
   * @param model
   * @return
   */
  @PostMapping(value = "/add")
  public String insert(@Validated Todo todo, BindingResult result, Model model) {
    if(result.hasErrors()) {
      return "todo/add";
    }
    service.insert(todo);
    return "redirect:/todo";
  }

  /**
   * 更新画面の表示
   * @param id
   * @param model
   * @return
   */
  @GetMapping(value = "/update/{taskId}")
  public String getUpdate(@PathVariable int taskId, Model model) {
	
	Todo todo = service.findOne(taskId);
	todo.setTaskId(taskId);

    model.addAttribute("todo",todo);
    
    return "todo/update";
  }

  /**
   * データを更新
   * @param id
   * @param todo
   * @param result
   * @param model
   * @return
   */
  @PutMapping(value = "/update/{taskId}")
  public String update(@PathVariable int taskId,@Validated Todo todo, BindingResult result, Model model) {
    if(result.hasErrors()) {
    	
      return "todo/update";
    }
    service.update(todo);
    return "redirect:/todo";
  }

  /**
   * データを削除
   * @param id
   * @return
   */
  @DeleteMapping(value = "/{taskId}")
  public String delete(@PathVariable int taskId) {
	  
    service.delete(taskId);
    return "redirect:/todo";
  }
}

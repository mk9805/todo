package com.example.todo.controller;

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

  //一覧
  @GetMapping
  public String index(Model model) {
    model.addAttribute("todos", service.searchAll());
    return "index";
  }

  // 追加画面を表示
  @GetMapping(value = "/add")
  public String getAdd(Model model, Todo todo) {
    return "todo/add";
  }

  // 新規データを追加
  @PostMapping(value = "/add")
  public String insert(@Validated Todo todo, BindingResult result, Model model) {
    
    if(result.hasErrors()) {
      return "todo/add";
    }
    
    service.insert(todo);
    model.addAttribute("todo", todo);
    return "redirect:/todo";
  }

  // 更新画面の表示
  @GetMapping(value = "/update/{id}")
  public String getUpdate(@PathVariable int id, Model model) {
    model.addAttribute("todo", service.findOne(id));
    return "todo/update";
  }

  // データを更新
  @PutMapping(value = "/update/{id}")
  public String update(@PathVariable int id, @Validated Todo todo, BindingResult result, Model model) {
    if(result.hasErrors()) {
      return "todo/update";
    }
    service.update(todo);
    model.addAttribute("todo", todo);
    return "redirect:/todo";
  }

  // 確認画面の表示
  @GetMapping(value = "/confirm/{id}")
  public String getConfirm(@PathVariable int id, Model model) {
    model.addAttribute("todo", service.findOne(id));
    return "todo/confirm";
  }

  // データを削除
  @DeleteMapping(value = "/confirm/{id}")
  public String delete(@PathVariable int id) {
    service.delete(id);
    return "redirect:/todo";
  }
}

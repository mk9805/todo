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

  /**
   * 一覧表示
   * @param model
   * @return
   */
  @GetMapping
  public String index(Model model) {
    model.addAttribute("todos", service.searchAll());
    return "index";
  }


  /**
   * 追加画面の表示
   * @param model
   * @param todo
   * @return
   */
  @GetMapping(value = "/add")
  public String getAdd(Model model, Todo todo) {
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
    model.addAttribute("todo", todo);
    return "redirect:/todo";
  }

  /**
   * 更新画面の表示
   * @param id
   * @param model
   * @return
   */
  @GetMapping(value = "/update/{id}")
  public String getUpdate(@PathVariable int id, Model model) {
    model.addAttribute("todo", service.findOne(id));
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
  @PutMapping(value = "/update/{id}")
  public String update(@PathVariable int id, @Validated Todo todo, BindingResult result, Model model) {
    if(result.hasErrors()) {
      return "todo/update";
    }
    service.update(todo);
    model.addAttribute("todo", todo);
    return "redirect:/todo";
  }

  /**
   * 確認画面の表示
   * @param id
   * @param model
   * @return
   */
  @GetMapping(value = "/confirm/{id}")
  public String getConfirm(@PathVariable int id, Model model) {
    model.addAttribute("todo", service.findOne(id));
    return "todo/confirm";
  }

  /**
   * データを削除
   * @param id
   * @return
   */
  @DeleteMapping(value = "/confirm/{id}")
  public String delete(@PathVariable int id) {
    service.delete(id);
    return "redirect:/todo";
  }
}

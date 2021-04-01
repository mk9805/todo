package com.example.todo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.todo.domain.Todo;
import com.example.todo.mapper.TodoMapper;

@Service
public class TodoService {

  @Autowired
  private TodoMapper mapper;
  
  //全件取得（一覧表示）
  public List<Todo> searchAll(){
    return mapper.selectAll();
  }
  //Todoを追加する
  public void insert(Todo todo) {
    mapper.insertTodo(todo);
  }
}

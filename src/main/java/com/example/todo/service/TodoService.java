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

  // 全件取得（一覧表示）
  public List<Todo> searchAll() {
    List<Todo> list = mapper.selectAll();
    return list;
  }

  // １件取得
  public Todo findOne(int id) {
    return mapper.findOne(id);
  }

  // 追加する
  public void insert(Todo todo) {
    mapper.insert(todo);
  }

  // 更新する
  public void update(Todo todo) {
    mapper.update(todo);
  }

  // 削除する
  public void delete(int id) {
    mapper.delete(id);
  }
}

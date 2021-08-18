package com.example.todo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.todo.domain.Todo;
import com.example.todo.mapper.TodoMapper;



@Service
public class TodoService {

  @Autowired
  private TodoMapper mapper;

  /**
   * 全件取得
   *
   */
  public List<Todo> searchAll() {
    List<Todo> list = mapper.selectAll();
    return list;
  }

  /**
   * 1件取得
   * @param id
   */
  @Transactional
  public Todo findOne(int taskId) {
    return mapper.findOne(taskId);
  }

  /**
   * 追加
   * @param todo
   */
  @Transactional
  public void insert(Todo todo) {
    mapper.insert(todo);
  }

  /**
   * 更新
   * @param todo
   */
  @Transactional
  public void update(Todo todo) {
    mapper.update(todo);
  }

  /**
   * 削除
   * @param id
   */
  @Transactional
  public void delete(int taskId) {
    mapper.delete(taskId);
  }
}

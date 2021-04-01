package com.example.todo.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.example.todo.domain.Todo;

@Mapper
public interface TodoMapper {

  //全件取得
  public List<Todo> selectAll();
  //データの追加
  public void insertTodo(Todo todo);
}

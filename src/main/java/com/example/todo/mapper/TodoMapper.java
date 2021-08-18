package com.example.todo.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.example.todo.domain.Todo;

@Mapper
public interface TodoMapper {

  // 全件取得
  public List<Todo> selectAll();

  // １件取得
  public Todo findOne(int taskId);

  // 追加
  public void insert(Todo todo);

  // 更新
  public void update(Todo todo);

  // 削除
  public void delete(int taskId);
}

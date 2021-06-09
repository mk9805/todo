package com.example.todo.domain;

import javax.validation.constraints.NotBlank;

public class Todo {

  private int id;

  @NotBlank(message = "入力してください")
  private String title;

  @NotBlank(message = "入力してください")
  private String deadline;
  
  @NotBlank(message = "選択してください")
  private String priority;

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public String getTitle() {
    return title;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  public String getDeadline() {
    return deadline;
  }

  public void setDeadline(String deadline) {
    this.deadline = deadline;
  }
  public String getPriority() {
    return priority;
  }

  public void setPriority(String priority) {
    this.priority = priority;
  }
}

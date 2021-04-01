package com.example.todo.domain;



import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;



public class Todo {

  private int id;
  private String title;
  @DateTimeFormat(pattern="yyyy-MM-dd")
  private Date deadLine;
  
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
  public Date getDeadLine() {
    return deadLine;
  }
  public void setDeadLine(Date deadLine) {
    this.deadLine=deadLine;
  }
  
}

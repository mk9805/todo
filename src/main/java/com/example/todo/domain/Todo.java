package com.example.todo.domain;

import java.time.LocalDate;

import javax.validation.constraints.FutureOrPresent;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.Data;

@Data
public class Todo {

  private int userId;
	
  private int taskId;

  @NotBlank(message="入力してください")
  private String title;

  @DateTimeFormat(pattern="yyyy-MM-dd")
  @NotNull(message="入力してください")
  @FutureOrPresent(message="今日以降の日付を入力してください")
  private LocalDate deadline;
  
  
  private int priority;
  
 
  private int stateId;
  
  private Status status;
}

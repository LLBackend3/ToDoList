package com.springboot.teamproject.Dao;

import com.springboot.teamproject.Entity.ToDo;

import java.util.List;

public interface ToDoListDao {
    ToDo insertToDo(ToDo todo); //새로운 할 일 추가

    ToDo selectToDoById(Long id) throws Exception; // ID로 할 일 조회

    ToDo updateTodo(Long id, String title, String description,boolean completed) throws Exception;
    // 할 일 업데이트

    void deleteToDo(Long id) throws Exception; // ID로 할 일 삭제

    List<ToDo> getAllToDos() throws Exception;  // 모든 할 일 조회
}

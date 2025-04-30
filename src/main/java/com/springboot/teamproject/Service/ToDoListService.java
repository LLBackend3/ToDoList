package com.springboot.teamproject.Service;

import com.springboot.teamproject.Dto.ToDoRequestDto;
import com.springboot.teamproject.Dto.ToDoResponseDto;

public interface ToDoListService {
    ToDoResponseDto getToDoById(Long id) throws Exception;
    ToDoResponseDto createToDo(ToDoRequestDto dto);
    ToDoResponseDto updateToDo(Long id, ToDoRequestDto dto) throws Exception;
    void deleteToDo(Long id) throws Exception;
    void getAllToDos() throws Exception;
}

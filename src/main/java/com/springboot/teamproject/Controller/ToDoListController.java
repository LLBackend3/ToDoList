package com.springboot.teamproject.Controller;


import com.springboot.teamproject.Dto.ToDoRequestDto;
import com.springboot.teamproject.Dto.ToDoResponseDto;
import com.springboot.teamproject.Entity.ToDo;
import com.springboot.teamproject.Service.ToDoListService;
import com.springboot.teamproject.Service.ToDoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/todos")
public class ToDoListController {

    private final ToDoListService toDoListService;

    @Autowired
    public ToDoListController(ToDoListService toDoListService) {
        this.toDoListService = toDoListService;
    }

    @PostMapping
    public ToDoResponseDto createToDo(@RequestBody ToDoRequestDto requestDto) {
        ToDo created = toDoListService.createToDo(requestDto);
        return toResponseDto(created);
    }

    @GetMapping("/{id}")
    public ToDoResponseDto getToDoById(@PathVariable Long id) throws Exception {
        ToDo todo = toDoListService.getToDoById(id);
        return toResponseDto(todo);
    }

    @GetMapping
    public List<ToDoResponseDto> getAllToDos() throws Exception {
        List<ToDo> todos = toDoListService.getAllToDos();
        return todos.stream().map(this::toResponseDto).collect(Collectors.toList());
    }

    @PutMapping("/{id}")
    public ToDoResponseDto updateToDo(@PathVariable Long id, @RequestBody ToDoRequestDto requestDto) throws Exception {
        ToDo updated = toDoListService.updateToDo(id, requestDto);
        return toResponseDto(updated);
    }

    @DeleteMapping("/{id}")
    public String deleteToDo(@PathVariable Long id) throws Exception {
        toDoListService.deleteToDo(id);
        return "삭제 완료 (id: " + id + ")";
    }
    
    private ToDoResponseDto toResponseDto(ToDo todo) {
        return new ToDoResponseDto(
                todo.getId(),
                todo.getUserName(),
                todo.getTitle(),
                todo.getDescription(),
                todo.isCompleted()
        );
    }
}
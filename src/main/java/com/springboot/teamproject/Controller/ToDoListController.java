package com.springboot.teamproject.Controller;


import com.springboot.teamproject.Dto.ToDoRequestDto;
import com.springboot.teamproject.Dto.ToDoResponseDto;
import com.springboot.teamproject.Entity.ToDo;
import com.springboot.teamproject.Service.ToDoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/todos")
public class ToDoListController {

    private final ToDoService toDoService;

    @Autowired
    public ToDoListController(ToDoService toDoService) {
        this.toDoService = toDoService;
    }

    @PostMapping
    public ToDoResponseDto createToDo(@RequestBody ToDoRequestDto requestDto) {
        ToDo created = toDoService.createToDo(requestDto);
        return toResponseDto(created);
    }

    @GetMapping("/{id}")
    public ToDoResponseDto getToDoById(@PathVariable Long id) throws Exception {
        ToDo todo = toDoService.getToDoById(id);
        return toResponseDto(todo);
    }

    @GetMapping
    public List<ToDoResponseDto> getAllToDos() throws Exception {
        List<ToDo> todos = toDoService.getAllToDos();
        return todos.stream().map(this::toResponseDto).collect(Collectors.toList());
    }

    @PutMapping("/{id}")
    public ToDoResponseDto updateToDo(@PathVariable Long id, @RequestBody ToDoRequestDto requestDto) throws Exception {
        ToDo updated = toDoService.updateToDo(id, requestDto);
        return toResponseDto(updated);
    }

    @DeleteMapping("/{id}")
    public String deleteToDo(@PathVariable Long id) throws Exception {
        toDoService.deleteToDo(id);
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
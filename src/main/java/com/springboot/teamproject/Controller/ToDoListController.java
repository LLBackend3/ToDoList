package com.springboot.teamproject.Controller;

import com.springboot.teamproject.Dto.ToDoRequestDto;
import com.springboot.teamproject.Dto.ToDoResponseDto;
import com.springboot.teamproject.Service.ToDoListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/todos")
public class ToDoListController {

    private final ToDoListService toDoListService;

    @Autowired
    public ToDoListController(ToDoListService toDoListService) {
        this.toDoListService = toDoListService;
    }

    @PostMapping
    public ResponseEntity<ToDoResponseDto> createToDo(@RequestBody ToDoRequestDto requestDto) {
        ToDoResponseDto responseDto = toDoListService.createToDo(requestDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(responseDto);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ToDoResponseDto> getToDoById(@PathVariable Long id) throws Exception {
        ToDoResponseDto responseDto = toDoListService.getToDoById(id);
        return ResponseEntity.ok(responseDto);
    }

    @GetMapping
    public ResponseEntity<List<ToDoResponseDto>> getAllToDos() throws Exception {
        List<ToDoResponseDto> allToDos = toDoListService.getAllToDos();
        return ResponseEntity.ok(allToDos);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ToDoResponseDto> updateToDo(@PathVariable Long id, @RequestBody ToDoRequestDto requestDto) throws Exception {
        ToDoResponseDto responseDto = toDoListService.updateToDo(id, requestDto);
        return ResponseEntity.ok(responseDto);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteToDo(@PathVariable Long id) throws Exception {
        toDoListService.deleteToDo(id);
        return ResponseEntity.ok("삭제 완료 (id: " + id + ")");
    }
}
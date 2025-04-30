package com.springboot.teamproject.Service.Impl;

import com.springboot.teamproject.Dao.ToDoListDao;
import com.springboot.teamproject.Dto.ToDoRequestDto;
import com.springboot.teamproject.Dto.ToDoResponseDto;
import com.springboot.teamproject.Entity.ToDo;
import com.springboot.teamproject.Service.ToDoListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

//import static jdk.javadoc.internal.doclets.formats.html.markup.HtmlStyle.title;

@Service
public class ToDoListImpl implements ToDoListService {
    private final ToDoListDao todoDAO;

    @Autowired
    public ToDoListImpl(ToDoListDao todoDAO){
        this.todoDAO = todoDAO;
    }

    @Override
    public ToDoResponseDto getToDoById(Long id) throws Exception{
        ToDo todo = todoDAO.selectToDoById(id);

        ToDoResponseDto todoResponseDto = new ToDoResponseDto();
        todoResponseDto.setId(todo.getId());
        todoResponseDto.setUserName(todo.getUserName());
        todoResponseDto.setTitle(todo.getTitle());
        todoResponseDto.setDescription(todo.getDescription());

        return todoResponseDto;
    }
    @Override
    public ToDoResponseDto createToDo(ToDoRequestDto todoRequestDto){
        ToDo todo = new ToDo();

        todo.setUserName(todoRequestDto.getUserName());
        todo.setTitle(todoRequestDto.getTitle());
        todo.setDescription(todoRequestDto.getDescription());

        ToDo savedToDo = todoDAO.insertToDo(todo);

        ToDoResponseDto todoResponseDto = new ToDoResponseDto();
        todoResponseDto.setId(savedToDo.getId());
        todoResponseDto.setUserName(savedToDo.getUserName());
        todoResponseDto.setTitle(savedToDo.getTitle());
        todoResponseDto.setDescription(savedToDo.getDescription());

        return todoResponseDto;
    }
    @Override
    public ToDoResponseDto updateToDo(Long id, ToDoRequestDto dto) throws Exception{
        ToDo findToDo = todoDAO.updateTodo(id, dto.getTitle(), dto.getDescription(), dto.isCompleted());

        ToDoResponseDto todoResponse = new ToDoResponseDto();
        todoResponse.setId(findToDo.getId());
        todoResponse.setUserName(findToDo.getUserName());
        todoResponse.setTitle(findToDo.getTitle());
        todoResponse.setDescription(findToDo.getDescription());

        return todoResponse;
    }

    @Override
    public void deleteToDo(Long id) throws Exception{
        todoDAO.deleteToDo(id);
    }

    @Override
    public List<ToDoResponseDto> getAllToDos() throws Exception {
        List<ToDo> toDos = todoDAO.getAllToDos();

        return toDos.stream().map(todo -> {
            ToDoResponseDto dto = new ToDoResponseDto();
            dto.setId(todo.getId());
            dto.setUserName(todo.getUserName());
            dto.setTitle(todo.getTitle());
            dto.setDescription(todo.getDescription());
            dto.setCompleted(todo.isCompleted());
            return dto;
        }).collect(Collectors.toList());
    }
}
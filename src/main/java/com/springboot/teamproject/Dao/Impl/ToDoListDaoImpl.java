package com.springboot.teamproject.Dao.Impl;

import com.springboot.teamproject.Dao.ToDoListDao;
import com.springboot.teamproject.Entity.ToDo;
import com.springboot.teamproject.Repository.ToDoListRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class ToDoListDaoImpl implements ToDoListDao {

    private final ToDoListRepository toDoListRepository;

    @Autowired
    public ToDoListDaoImpl(ToDoListRepository toDoListRepository) {
        this.toDoListRepository = toDoListRepository;
    }

    @Override
    public ToDo insertToDo(ToDo todo) {
        return toDoListRepository.save(todo);
    }

    @Override
    public ToDo selectToDoById(Long id) throws Exception {
        Optional<ToDo> todo = toDoListRepository.findById(id);

        if (todo.isPresent()) {
            return todo.get();
        } else {
            throw new Exception("해당 ID에 해당하는 ToDo 항목이 존재하지 않습니다.");
        }
    }

    @Override
    public ToDo updateTodo(Long id, String title, String description, boolean completed) throws Exception {
        Optional<ToDo> findToDo = toDoListRepository.findById(id);

        if (findToDo.isPresent()) {
            ToDo todo = findToDo.get();
            todo.setTitle(title);
            todo.setDescription(description);
            todo.setCompleted(completed);
            return toDoListRepository.save(todo);
        } else {
            throw new Exception("해당 ID에 해당하는 ToDo 항목이 존재하지 않습니다.");
        }
    }

    @Override
    public void deleteToDo(Long id) throws Exception {
        Optional<ToDo> findToDo = toDoListRepository.findById(id);

        if (findToDo.isPresent()) {
            toDoListRepository.delete(findToDo.get());
        } else {
            throw new Exception("해당 ID에 해당하는 ToDo 항목이 존재하지 않습니다.");
        }
    }

    @Override
    public List<ToDo> getAllToDos() throws Exception {
        List<ToDo> todoList = toDoListRepository.findAll();

        if (todoList.isEmpty()) {
            throw new Exception("할 일이 존재하지 않습니다.");
        } else {
            return todoList;
        }
    }
}

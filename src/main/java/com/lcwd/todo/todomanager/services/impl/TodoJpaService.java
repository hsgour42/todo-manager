package com.lcwd.todo.todomanager.services.impl;

import com.lcwd.todo.todomanager.dao.TodoRepository;
import com.lcwd.todo.todomanager.models.Todo;
import com.lcwd.todo.todomanager.services.TodoService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
@Primary
public class TodoJpaService implements TodoService {
    @Autowired
    private TodoRepository todoRepository;
    Logger logger = LoggerFactory.getLogger(TodoJpaService.class);

    @Override
    public Todo createTodo(Todo newTodo) {
        Date currentDate = new Date();
        newTodo.setTodoDate(currentDate);
       Todo todo  = todoRepository.save(newTodo);
       return  todo;
    }

    @Override
    public List<Todo> getAllTodos() throws ParseException {
        List<Todo> todoList = todoRepository.findAll();
        return  todoList;
    }

    @Override
    public Todo getSingleTodo(int todoId) throws ParseException {
        Optional<Todo> todoOptional = todoRepository.findById(todoId);
         Todo todo = todoOptional.orElseThrow(() -> new RuntimeException("No todo available with given todo id"));
         return  todo;
    }

    @Override
    public Todo updateTodo(Todo updatedTodo, int todoId) {
        Optional<Todo> todoOptional = todoRepository.findById(todoId);
        Todo oldTodo = todoOptional.orElseThrow(() -> new RuntimeException("No todo available with given todo id"));
        oldTodo.setTitle(updatedTodo.getTitle());
        oldTodo.setContent(updatedTodo.getContent());
        oldTodo.setStatus(updatedTodo.getStatus());
         return todoRepository.save(oldTodo);
    }

    @Override
    public String deleteTodo(int todoId) {
        Optional<Todo> todoOptional = todoRepository.findById(todoId);
        Todo oldTodo = todoOptional.orElseThrow(() -> new RuntimeException("No todo available with given todo id"));
        todoRepository.delete(oldTodo);
        return "todo is deleted";
    }
}

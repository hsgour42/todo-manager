package com.lcwd.todo.todomanager.services.impl;

import com.lcwd.todo.todomanager.dao.TodoDao;
import com.lcwd.todo.todomanager.models.Todo;
import com.lcwd.todo.todomanager.services.TodoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.util.Date;
import java.util.List;

@Service
//@Primary
public class DaoTodoServiceImpl implements TodoService {

    @Autowired
    private TodoDao todoDao;


    @Override
    public Todo createTodo(Todo todo) {
        Date currentDate = new Date();
        todo.setTodoDate(currentDate);
        return todoDao.saveTodo(todo);
    }

    @Override
    public List<Todo> getAllTodos() throws ParseException {
        return todoDao.getAllTodos();
    }

    @Override
    public Todo getSingleTodo(int todoId) throws ParseException {
        return todoDao.getSingleTodo(todoId);
    }

    @Override
    public Todo updateTodo(Todo updatedTodo, int todoId) {
        Date currentDate = new Date();
        updatedTodo.setTodoDate(currentDate);
        return todoDao.updateTodo(updatedTodo , todoId);
    }

    @Override
    public String deleteTodo(int todoId) {
        return todoDao.deleteTodo(todoId);
    }
}

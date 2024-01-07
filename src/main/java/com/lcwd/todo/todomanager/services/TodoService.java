package com.lcwd.todo.todomanager.services;

import com.lcwd.todo.todomanager.models.Todo;

import java.text.ParseException;
import java.util.List;

public interface TodoService {
    public Todo createTodo(Todo todo);
    public List<Todo> getAllTodos() throws ParseException;
    public Todo getSingleTodo(int todoId) throws ParseException;
    public Todo updateTodo(Todo updatedTodo , int todoId);
    public String deleteTodo(int todoId);
}

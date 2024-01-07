package com.lcwd.todo.todomanager.services.impl;

import com.lcwd.todo.todomanager.exceptions.ResourceNotFoundException;
import com.lcwd.todo.todomanager.models.Todo;
import com.lcwd.todo.todomanager.services.TodoService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;



//we are ignoring dummy service
//@Component
@Service
public class TodoServiceImpl implements TodoService {
    //fake database
    List<Todo> todos = new ArrayList<>();
    //logger
    Logger logger = LoggerFactory.getLogger(TodoServiceImpl.class);

    //create todo method
    public Todo createTodo(Todo todo){
        //create
        todos.add(todo);
        logger.info("Todos list {} " , this.todos);
        return todo;
    }

    //get all todos
    public List<Todo> getAllTodos(){
        return this.todos;
    }

    //get single todo
    public Todo getSingleTodo(int todoId){
        Todo todo= todos.stream().filter( t ->
                      todoId == t.getId()).findAny().orElseThrow
                        (() -> new ResourceNotFoundException("Todo not found", HttpStatus.NOT_FOUND));

        logger.info("TODO : {}" , todo);
        return  todo;
    }

    //update todo
    public Todo updateTodo(Todo updatedTodo , int todoId){

        todos = todos.stream().map(t -> {
             if(t.getId() == todoId){
                 //perform action
                 t.setTitle(updatedTodo.getTitle());
                 t.setContent(updatedTodo.getContent());
                 t.setStatus(updatedTodo.getStatus());
             }
             return  t;
         }).collect(Collectors.toList());
       return  updatedTodo;
    }

    //delete todo
    public String deleteTodo(int todoId){
        List<Todo> newList = todos.stream().filter(t -> t.getId() != todoId).collect(Collectors.toList());
        todos = newList;
        return "Todo is successfully deleted";
    }
}

package com.lcwd.todo.todomanager.controllers;

import com.lcwd.todo.todomanager.models.Todo;
import com.lcwd.todo.todomanager.services.TodoService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.util.List;
import java.util.Random;

@RestController
@RequestMapping("/todos")
public class TodoController {
    //logger
    Logger logger = LoggerFactory.getLogger(TodoController.class);
    //service
    @Autowired
    private TodoService todoService;
    //handle id
    Random random = new Random();

    //create todo
    @PostMapping
    public ResponseEntity<Todo> createTodoHandler(@RequestBody Todo todo){
        //Generate exception
        //String str = null;
        //System.out.println(str.length());
        //Integer.parseInt("7687jkh");

        Todo todo1 = todoService.createTodo(todo);
        return new ResponseEntity<>(todo1, HttpStatus.CREATED);
    }

    //get all todo
    @GetMapping
    public ResponseEntity<List<Todo>> getAllTodoHandler() throws ParseException {
        List<Todo> allTodos = todoService.getAllTodos();
        return new ResponseEntity<>(allTodos, HttpStatus.OK);
    }

    //get single todo
    @GetMapping("/{todoId}")
    public ResponseEntity<Todo> getSingleTodoHandler(@PathVariable int todoId) throws ParseException {
        Todo todo  = todoService.getSingleTodo(todoId);
        return  ResponseEntity.ok(todo);
    }

    //update todo
    @PutMapping("/{todoId}")
    public ResponseEntity<Todo> updateTodoHandler(@RequestBody Todo updatedTodo , @PathVariable int todoId){
        Todo todo = todoService.updateTodo(updatedTodo , todoId);
        return ResponseEntity.ok(todo);
    }

    //delete todo
    @DeleteMapping("/{todoId}")
    public ResponseEntity<String> deleteTodoHandler(@PathVariable int todoId){
        String result = todoService.deleteTodo(todoId);
        return  ResponseEntity.ok(result);
    }


    //This exception handler work only for this class
    //handle exceptions
    //Make global handler

    //Or

//    @ExceptionHandler(value = {NullPointerException.class ,NumberFormatException.class})
//    public  ResponseEntity<String> NullPointerExceptionHandler(Exception e){
//        System.out.println(e.getMessage());
//        System.out.println("exception generated");
//        return new ResponseEntity<>("\"exception generated because \" "+ e.getMessage() , HttpStatus.INTERNAL_SERVER_ERROR);
//
//    }

    //OR

//    @ExceptionHandler(NullPointerException.class)
//    public  ResponseEntity<String> NullPointerExceptionHandler(NullPointerException e){
//        System.out.println(e.getMessage());
//        System.out.println("exception generated");
//        return new ResponseEntity<>("\"NUll Pointer exception because \" "+ e.getMessage() , HttpStatus.INTERNAL_SERVER_ERROR);
//
//    }
//
//    @ExceptionHandler(NumberFormatException.class)
//    public  ResponseEntity<String> numberPointerExceptionHandler(NumberFormatException e){
//        System.out.println(e.getMessage());
//        System.out.println("exception generated");
//        return new ResponseEntity<>("\"NUll Pointer exception because \" "+ e.getMessage() , HttpStatus.INTERNAL_SERVER_ERROR);
//
//    }
}

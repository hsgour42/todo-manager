package com.lcwd.todo.todomanager.dao;

import com.lcwd.todo.todomanager.Helper.DateHelper;
import com.lcwd.todo.todomanager.models.Todo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.text.ParseException;
import java.util.List;

@Repository
public class TodoDao {
    Logger logger = LoggerFactory.getLogger(TodoDao.class);

    private  JdbcTemplate template;

    public TodoDao(@Autowired JdbcTemplate template) {
        this.template = template;
        //if table is not created , create table
        String createTable = "create table IF NOT EXISTS todos" +
                "(" +
                "id int primary key, " +
                "title varchar(100) not null," +
                "content varchar(500)," +
                "status varchar(10) not null," +
                "todoDate datetime" +
                ")";

        int update =template.update(createTable);
    }

    public JdbcTemplate getJdbcTemplate() {
        return template;
    }

    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.template = jdbcTemplate;
    }



    //sava todo to database
    public Todo saveTodo(Todo todo){
        String insertQuery ="insert into todos(title,content,status,todoDate) values (?,?,?,?)";
        int rows = template.update(insertQuery , todo.getTitle(),todo.getContent(),todo.getStatus(),todo.getTodoDate());
        return todo;
    }

    //get single todo from database
    public Todo getSingleTodo(int id) throws ParseException {
        String query = "select * from todos where id=?";
        //check TodoRowMapper class
        Todo todo = template.queryForObject(query , new TodoRowMapper() ,id);
        return todo;
    }

    //get all todo from database
    public List<Todo> getAllTodos() throws ParseException {
        String query = "select * from todos";
        List<Todo> todos = template.query(query , new TodoRowMapper());
        return todos;
    }

    //update todo
    public Todo updateTodo( Todo updatedTodo, int id ){
        String updateQuery = "update todos set title = ? , content = ? , status = ? , todoDate = ? where id = ?";
        int row = template.update(
                        updateQuery ,
                        updatedTodo.getTitle() ,
                        updatedTodo.getContent() ,
                        updatedTodo.getStatus(),
                        updatedTodo.getTodoDate(),
                        id
        );

        return updatedTodo;
    }

    //delete todo
    public String deleteTodo(int id){
        String deleteQuery = "delete from todos where id = ?";
        int row = template.update(deleteQuery , id);
        return "Deleted row : " + row;
    }

}

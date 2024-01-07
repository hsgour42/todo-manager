package com.lcwd.todo.todomanager;

import com.lcwd.todo.todomanager.dao.TodoDao;
import com.lcwd.todo.todomanager.models.Todo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.Date;
import java.util.List;

@SpringBootApplication
public class TodoManagerApplication implements CommandLineRunner {
	Logger logger = LoggerFactory.getLogger(TodoManagerApplication.class);

//	@Autowired
//	public TodoDao todoDao;

	public static void main(String[] args) {
		SpringApplication.run(TodoManagerApplication.class, args);
	}


	@Override
	public void run(String... args) throws Exception {
//		System.out.println("Application running: ");
//		JdbcTemplate jdbcTemplate = todoDao.getJdbcTemplate();
//		logger.info("Templete Object {} " , jdbcTemplate );
//		logger.info("Templete Object {} " , jdbcTemplate.getDataSource() );

		//insert todo
//		Todo newTodo = new Todo();
//		newTodo.setTitle("React");
//		newTodo.setContent("Learn React");
//		newTodo.setStatus("Not Done");
//		newTodo.setTodoDate(new Date());
		//todoDao.saveTodo(newTodo);

		//single todo fetch
		//Todo todoById = todoDao.getSingleTodo(1);

		//all todo fetch
		//List<Todo> todoList = todoDao.getAllTodos();
		//Todo todo1 = todoList.get(0);
		//logger.info("first todo from list of todo : {}" , todo1);


		//update todo
//		Todo updatedTodo = new Todo();
//		updatedTodo.setTitle("Node Js");
//		updatedTodo.setContent("Learn Node Js");
//		updatedTodo.setStatus("Done");
//		updatedTodo.setTodoDate(new Date());
		//todoDao.updateTodo(2 , updatedTodo);


		//delete todo
		//todoDao.deleteTodo(2);

	}
}

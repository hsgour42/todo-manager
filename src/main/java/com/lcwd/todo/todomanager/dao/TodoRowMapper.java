package com.lcwd.todo.todomanager.dao;

import com.lcwd.todo.todomanager.Helper.DateHelper;
import com.lcwd.todo.todomanager.models.Todo;
import org.springframework.jdbc.core.RowMapper;

import javax.swing.tree.TreePath;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.time.LocalDateTime;
import java.util.Date;

public class TodoRowMapper implements RowMapper<Todo> {

    @Override
    public Todo mapRow(ResultSet rs, int rowNum) throws SQLException {
        Todo todo = new Todo();
        int todoId = rs.getInt("id");
        String title =rs.getString("title");
        String content = rs.getString("content");
        String status = rs.getString("status");
        //handling date
        LocalDateTime localDateTimeTodoDate = (LocalDateTime)rs.getObject("todoDate");
        Date todoDate = null;
        try {
            todoDate = DateHelper.parseDate(localDateTimeTodoDate);
        } catch (ParseException e) {
            e.printStackTrace();
        }

        //set all data
        todo.setId(todoId);
        todo.setTitle(title);
        todo.setContent(content);
        todo.setStatus(status);
        todo.setTodoDate(todoDate);
        return todo;
    }
}

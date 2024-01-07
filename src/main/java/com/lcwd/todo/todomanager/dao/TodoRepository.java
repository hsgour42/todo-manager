package com.lcwd.todo.todomanager.dao;

import com.lcwd.todo.todomanager.models.Todo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TodoRepository extends JpaRepository<Todo , Integer> {
}

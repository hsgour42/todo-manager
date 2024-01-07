package com.lcwd.todo.todomanager.models;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import org.springframework.context.annotation.Primary;

import java.util.Date;

@Entity
@Table(name = "jpa_todos")
public class Todo {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column(length = 50)
    private String title;

    @Column
    private String content;

    @Column(length = 20 ,nullable = false)
    private String status;

    @JsonFormat(pattern = "MM/dd/yyyy")
    @Column
    private Date todoDate;


    public Todo(int id, String title, String content, String status,Date todoDate) {
        this.id = id;
        this.title = title;
        this.content = content;
        this.status = status;
        this.todoDate = todoDate;
    }

    public Todo() {

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Date getTodoDate() {
        return todoDate;
    }

    public void setTodoDate(Date todoDate) {
        this.todoDate = todoDate;
    }

    @Override
    public String toString() {
        return "Todo{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", content='" + content + '\'' +
                ", status='" + status + '\'' +
                ", todoDate=" + todoDate +
                '}';
    }
}

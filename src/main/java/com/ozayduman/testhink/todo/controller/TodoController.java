package com.ozayduman.testhink.todo.controller;

import com.ozayduman.testhink.todo.service.TodoService;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TodoController {

    private final TodoService todoService;

    public TodoController(TodoService todoService) {
        this.todoService = todoService;
    }

    @RequestMapping("/todo/{taskId}")
    public String getTitleFor(@PathVariable final String taskId)
    {
        var todo = todoService.getTaskDetail(taskId);
        return todo.getTitle();
    }
}

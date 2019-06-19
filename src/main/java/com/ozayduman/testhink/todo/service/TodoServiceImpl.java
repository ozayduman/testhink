package com.ozayduman.testhink.todo.service;

import com.ozayduman.testhink.todo.dto.Todo;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class TodoServiceImpl implements TodoService {

    private final RestTemplate restTemplate;
    private static final String todoServiceUrlTemplate = "https://jsonplaceholder.typicode.com/todos/%s";

    public TodoServiceImpl(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @Override
    public Todo getTaskDetail(String taskId){
        var todo = restTemplate.getForObject(String.format(todoServiceUrlTemplate, taskId), Todo.class);
        if(todo.getTitle().contains("ozay")){
            todo.setTitle("<"+todo.getTitle() + ">");
        }
        return todo;
    }
}

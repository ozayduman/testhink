package com.ozayduman.testhink.hard2testcode;

import com.ozayduman.testhink.todo.dto.Todo;
import org.springframework.web.client.RestTemplate;

public class Task {

    private String title;

    /*
     * cost of construction sample
     * object creation in constructor
     * doing work in constructor
     */
    public Task(String documentId) {
        var restTemplate = new RestTemplate();
        var todo = restTemplate.getForObject(String.format("https://jsonplaceholder.typicode.com/todos/%s", documentId), Todo.class);
        title = todo.getTitle().contains("ozay") ? "duman": todo.getTitle();
    }

    public String getTitle() {
        return title;
    }
}

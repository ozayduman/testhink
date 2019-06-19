package com.ozayduman.testhink.hard2testcode;

import com.ozayduman.testhink.todo.dto.Todo;
import org.springframework.web.client.RestTemplate;

public class TaskV2 {

    private String title;

    /*
     * cost of construction sample
     *
     * doing work in constructor
     */
    public TaskV2(RestTemplate restTemplate, String documentId) {
        var todo = restTemplate.getForObject(String.format("https://jsonplaceholder.typicode.com/todos/%s", documentId), Todo.class);
        title = todo.getTitle().contains("ozay") ? "duman": todo.getTitle();
    }

    public String getTitle() {
        return title;
    }
}

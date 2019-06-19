package com.ozayduman.testhink.todo.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
public class Todo implements Serializable {
    private String userId;
    private String id;
    private String title;
    private boolean completed;
}

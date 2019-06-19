package com.ozayduman.testhink.todo.controller;

import com.ozayduman.testhink.person.controller.PersonController;
import com.ozayduman.testhink.person.controller.PersonControllerImpl;
import com.ozayduman.testhink.person.repository.PersonRepository;
import com.ozayduman.testhink.todo.dto.Todo;
import com.ozayduman.testhink.todo.service.TodoService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import static org.hamcrest.Matchers.containsString;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
/*
Spring Boot is only instantiating the web layer, not the whole context.
In an application with multiple controllers you can even ask for just one to be instantiated,
using, for example @WebMvcTest(TodoController.class)
 */
@RunWith(SpringRunner.class)
@WebMvcTest(TodoController.class)
public class WebLayerTest {
    public static final String DEFAULT_TITLE = "default title";
    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private TodoService todoService;

    @MockBean
    private PersonRepository repository;


    @Test
    public void shouldReturnDefaultMessage() throws Exception {
        //when
        Todo todo = new Todo();
        todo.setId("1");
        todo.setTitle(DEFAULT_TITLE);
        todo.setCompleted(true);
        todo.setUserId("userId-xyz");
        Mockito.when(todoService.getTaskDetail(Mockito.anyString())).thenReturn(todo);
        //Action & Then
        this.mockMvc.perform(MockMvcRequestBuilders.get("/todo/1")).andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(content().string(containsString(DEFAULT_TITLE)));
    }
}

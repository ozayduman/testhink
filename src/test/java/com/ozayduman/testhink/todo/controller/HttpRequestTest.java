package com.ozayduman.testhink.todo.controller;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.test.context.junit4.SpringRunner;

/*
This test start a server with random port
 */
@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class HttpRequestTest {

    public static final String EXPECTED_RESULT = "delectus aut autem";
    @LocalServerPort
    private int port;

    @Autowired
    private TestRestTemplate testRestTemplate;

    @Test
    public void getTodoShouldReturnDefaultMessage() {
        //Given
        String taskId = "1";
        //When
        String result = this.testRestTemplate.getForObject(String.format("http://localhost:%s/todo/%s", port,taskId), String.class);
        //Then
        Assert.assertEquals(EXPECTED_RESULT,result);
    }
}

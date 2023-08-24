package com.example.restconsume.controller;

import com.example.restconsume.dto.Todo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/todo")
public class TodoController {

    @Autowired
    private RestTemplate restTemplate ;

    // localhost:9001/todo/getTodoList
    @GetMapping("/getTodoList")
    public ResponseEntity<Todo[]> getTodoList ( ) {
        ResponseEntity<Todo[]> entity = restTemplate.getForEntity("https://jsonplaceholder.typicode.com/todos", Todo[].class);
        return entity;
    }

    // localhost:9001/todo/getTodoList1
    @GetMapping("/getTodoList1")
    public ResponseEntity<List<Todo>> getTodoList1 ( ) {
        ResponseEntity<Todo[]> entity = restTemplate.getForEntity("https://jsonplaceholder.typicode.com/todos", Todo[].class);
        List<Todo> todoList = Arrays.asList(entity.getBody());
        return new ResponseEntity(todoList, HttpStatus.MULTI_STATUS.OK);
    }
}

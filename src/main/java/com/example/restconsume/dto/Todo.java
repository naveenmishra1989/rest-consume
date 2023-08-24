package com.example.restconsume.dto;

import lombok.Data;

@Data
public class Todo {
    private Integer userId;
    private Integer id;
    private String title;
    private Boolean completed;
}

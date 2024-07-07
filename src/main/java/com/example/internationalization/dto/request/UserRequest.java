package com.example.internationalization.dto.request;

import lombok.Data;

@Data
public class UserRequest {
    private String name;

    private String surname;

    private String username;

    private Integer age;
}

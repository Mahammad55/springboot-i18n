package com.example.internationalization.dto.response;

import lombok.Data;

@Data
public class UserResponse {
    private Long id;

    private String name;

    private String surname;

    private String username;

    private Integer age;
}

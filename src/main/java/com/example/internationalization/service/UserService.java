package com.example.internationalization.service;

import com.example.internationalization.dto.request.UserRequest;
import com.example.internationalization.dto.response.UserResponse;

import java.util.List;

public interface UserService {
    UserResponse getUser(Long id);

    List<UserResponse> getAllUser();

    void saveUser(UserRequest userRequest);

    void updateUser(Long id, UserRequest userRequest);

    void deleteUser(Long id);
}

package com.example.internationalization.service.impl;

import com.example.internationalization.dto.request.UserRequest;
import com.example.internationalization.dto.response.UserResponse;
import com.example.internationalization.entity.User;
import com.example.internationalization.exception.AlreadyExistException;
import com.example.internationalization.exception.NotFoundException;
import com.example.internationalization.repository.UserRepository;
import com.example.internationalization.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

import static com.example.internationalization.mapper.UserMapper.INSTANCE;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;

    @Override
    public UserResponse getUser(Long id) {
        User user = userRepository.findById(id).orElseThrow(NotFoundException::new);
        return INSTANCE.entityToResponse(user);
    }

    @Override
    public List<UserResponse> getAllUser() {
        List<User> userList = userRepository.findAll();
        if (userList.isEmpty()) throw new NotFoundException();
        return userList.stream().map(INSTANCE::entityToResponse).toList();
    }

    @Override
    public void saveUser(UserRequest userRequest) {
        if (userRepository.existsUsersByUsername(userRequest.getUsername())) throw new AlreadyExistException();
        User user = INSTANCE.requestToEntity(userRequest);
        userRepository.save(user);
    }

    @Override
    public void updateUser(Long id, UserRequest userRequest) {
        userRepository.findById(id).orElseThrow(NotFoundException::new);
        User user = INSTANCE.requestToEntity(userRequest);
        user.setId(id);
        userRepository.save(user);
    }

    @Override
    public void deleteUser(Long id) {
        User user = userRepository.findById(id).orElseThrow(NotFoundException::new);
        userRepository.delete(user);
    }
}

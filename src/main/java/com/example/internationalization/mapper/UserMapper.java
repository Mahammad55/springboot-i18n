package com.example.internationalization.mapper;

import com.example.internationalization.dto.request.UserRequest;
import com.example.internationalization.dto.response.UserResponse;
import com.example.internationalization.entity.User;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public abstract class UserMapper {
    public static final UserMapper INSTANCE = Mappers.getMapper(UserMapper.class);

    public abstract UserResponse entityToResponse(User user);

    public abstract User requestToEntity(UserRequest userRequest);
}

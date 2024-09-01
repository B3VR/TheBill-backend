package com.example.thebillbackend.authorization.mappers;

import com.example.thebillbackend.authorization.dtos.SignUpDto;
import com.example.thebillbackend.authorization.dtos.UserDto;
import com.example.thebillbackend.authorization.entities.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface UserMapper {

    @Mapping(target = "token", ignore = true)
    UserDto toUserDto(User user);

    @Mapping(target = "password", ignore = true)
    @Mapping(target = "id", ignore = true)
    User signUpToUser(SignUpDto userDto);
}

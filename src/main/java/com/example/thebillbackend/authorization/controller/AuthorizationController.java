package com.example.thebillbackend.authorization.controller;

import com.example.thebillbackend.authorization.dtos.CredentialsDto;
import com.example.thebillbackend.authorization.dtos.SignUpDto;
import com.example.thebillbackend.authorization.dtos.UserDto;
import com.example.thebillbackend.authorization.services.UserService;
import com.example.thebillbackend.config.UserAuthProvider;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import java.net.URI;

@Controller
@RequiredArgsConstructor
@RequestMapping(value = "/auth")
public class AuthorizationController {

    private final UserService userService;
    private final UserAuthProvider userAuthProvider;

    @PostMapping(path = "/login")
    public ResponseEntity<UserDto> logIn(@RequestBody CredentialsDto credentialsDto) {
        UserDto userDto = userService.login(credentialsDto);
        userDto.setToken(userAuthProvider.createToken(userDto));
        return ResponseEntity.ok(userDto);
    }

    @PostMapping(path = "/register")
    public ResponseEntity<UserDto> register(@RequestBody SignUpDto signUpDto) {
        UserDto user = userService.register(signUpDto);
        user.setToken(userAuthProvider.createToken(user));
        return ResponseEntity.created(URI.create("/users/" + user.getId())).body(user);
    }
}

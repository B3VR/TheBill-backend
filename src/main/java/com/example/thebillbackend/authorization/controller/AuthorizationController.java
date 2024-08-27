package com.example.thebillbackend.authorization.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping(value = "/auth")
public class AuthorizationController {

    @GetMapping
    @ResponseBody
    public String logIn() {
        return "Hello";
    }
}

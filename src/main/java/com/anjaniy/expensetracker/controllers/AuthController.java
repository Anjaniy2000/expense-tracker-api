package com.anjaniy.expensetracker.controllers;

import com.anjaniy.expensetracker.dto.LoginRequest;
import com.anjaniy.expensetracker.dto.LoginResponse;
import com.anjaniy.expensetracker.dto.RegisterRequest;
import com.anjaniy.expensetracker.services.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    private AuthService authService;

    @PostMapping("/register")
    @ResponseStatus(HttpStatus.CREATED)
    public String register(@RequestBody RegisterRequest registerRequest) throws Exception {
        authService.register(registerRequest);
        return "User Registration Successful";
    }

    @PostMapping("/login")
    @ResponseStatus(HttpStatus.OK)
    public LoginResponse login(@RequestBody LoginRequest loginRequest){
        return authService.login(loginRequest);
    }
}

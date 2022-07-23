package com.anjaniy.expensetracker.controllers;

import com.anjaniy.expensetracker.services.AppUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/profile")
public class AppUserController {

    @Autowired
    private AppUserService appUserService;

    @GetMapping("/reset")
    @ResponseStatus(HttpStatus.OK)
    public String reset(){
        appUserService.reset();
        return "Profile Reset Successfully";
    }
}

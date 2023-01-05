package com.learning.fse.firstapp.api;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

@RestController
@RequestMapping("/api")
public class WelcomeAPI {

    @GetMapping("/messages")
    public String getMessage(){
        return "Welcome to Restful web services";
    }

    @GetMapping("/date")
    public String getDate(){
        return new Date().toString();
    }
}

package com.lppz.web.controller;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;



@RestController
public class BaseController {

    @Value("${name}")
    private String name;
    @RequestMapping("/login")
    public String Login(){
        System.out.println(name);
        return "hello SpringBoot----"+name;
    }
}

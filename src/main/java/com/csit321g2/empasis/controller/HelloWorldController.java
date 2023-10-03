package com.csit321g2.empasis.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWorldController {

    @GetMapping("/hello")
    public @ResponseBody String hello(
            @RequestParam(name = "fname", defaultValue = "john") String fname,
            @RequestParam(name = "lname", defaultValue = "doe") String lname) {
        return "Hello, " + fname + " " + lname + "!";
    }
}

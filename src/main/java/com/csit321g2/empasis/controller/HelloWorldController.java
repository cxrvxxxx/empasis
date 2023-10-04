package com.csit321g2.empasis.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWorldController {
    @GetMapping("/hello")
    public ResponseEntity<String> hello(
            // Specify URI Parameters
            @RequestParam(name = "fname", defaultValue = "john") String fname,
            @RequestParam(name = "lname", defaultValue = "doe") String lname) {
        return new ResponseEntity<>("Hello, " + fname + " " + lname + "!", HttpStatus.OK);
    }
}

package com.example.calculadora.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller {

    @GetMapping("/")
    public String hello() {
        return "Hello Friend!!";
    }

    @GetMapping("/sum/{num1}/{num2}")
    public int suma(@PathVariable int num1, @PathVariable int num2) {
        return num1 + num2;
    }
}

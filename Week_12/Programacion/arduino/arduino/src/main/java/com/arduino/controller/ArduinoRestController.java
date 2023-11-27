package com.arduino.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/api")
@CrossOrigin(origins = "*")
@RestController
public class ArduinoRestController {
	
	String color = "";
	//Humedad máxima, humedad actual, temperatura máxima, temperatura actual
	//Hora actual, hora de temperatura máxima, hora de humedad máxima.
	
	@GetMapping("/")
	public String hello(){
		return "The Arduino API is online";
	}
	
	@GetMapping("/color")
	public String getColor(){
		return color;
	}
	
	@PostMapping("/color")
	public void setColor(@RequestBody String color){
		this.color = color;
	}

}

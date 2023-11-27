package com.arduino.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class ArduinoPageController {
	
	@RequestMapping("/")
    public String welcome() {
        return "index";
    }
	

}

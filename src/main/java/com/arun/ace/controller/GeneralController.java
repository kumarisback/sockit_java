package com.arun.ace.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class GeneralController {
	
	@GetMapping("/")
	public String home() {
		return "It's your home page";
	}
}

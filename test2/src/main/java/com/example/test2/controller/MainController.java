package com.example.test2.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MainController{
	
//	@GetMapping(value = "/")
//	public String index() {
//		return "/index";
//	}
//	
//	@GetMapping(value = "test")
//	public String test() {
//		return "/test";
//	}
	
	@GetMapping("/index")
	public String index() {
		return "index";
	}
	
	
}
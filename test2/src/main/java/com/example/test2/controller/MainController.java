package com.example.test2.controller;


import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

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
	
	@RequestMapping(value="/", method=RequestMethod.GET)
	public String index() {
		System.out.print("main");
		return "index";
	}
	
	@GetMapping("/test")
	public String test() {
		return "test";
	}
	
	@RequestMapping(value="/test/test2", method=RequestMethod.GET)
	public String test2() {
		return "test";
	}
	
	
}
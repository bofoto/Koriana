package com.koriana.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
public class ViewController {
	
	@GetMapping("/flights")
	public String openView() {
		return "koriana/home";
	}
	
	@GetMapping("/flights/test")
	public String openTest() {
		return "koriana/test";
	}
}

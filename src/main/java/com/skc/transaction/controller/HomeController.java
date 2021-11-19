package com.skc.transaction.controller;

import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class HomeController {

	@GetMapping("/")
	public String index(Map<String, Object> model) {
		model.putIfAbsent("message", "Welcome to my page");
		return "index";
	}

}

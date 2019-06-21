package com.dianmandiri.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class IndexController {

	
	
	@GetMapping("/")
	public String index(Model model) {
		
		model.addAttribute("title", "Dashboard");
		model.addAttribute("h2", "Welcome To Sistem");
		return "index5";
	}
	
}

package com.kloudspot.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.security.core.Authentication;
import org.springframework.ui.Model;

@RestController
@RequestMapping("/")
public class IndexController {

	@GetMapping
	public String index(Model model,Authentication user) {
		model.addAttribute("user",user);
		return "index";
	}
}

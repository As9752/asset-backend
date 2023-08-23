package com.kloudspot.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

	@GetMapping("/group1")
	@PreAuthorize("hasRole('ROLE_GROUP1')")
	public String group1() {
		return "hello group1 users";
	}
}

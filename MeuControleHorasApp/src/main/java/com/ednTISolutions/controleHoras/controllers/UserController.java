package com.ednTISolutions.controleHoras.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ednTISolutions.controleHoras.models.User;
import com.ednTISolutions.controleHoras.services.UserService;

@RestController
public class UserController {

	@Autowired
	private UserService service;
	
	@GetMapping("/usuarios")
	public List<User> list() {
		return service.list();
	}
	
}

package com.ednTISolutions.controleHoras.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ednTISolutions.controleHoras.models.User;
import com.ednTISolutions.controleHoras.services.UserService;

@RestController
@RequestMapping("/auth")
public class UserController {

	@Autowired
	private UserService service;

	@GetMapping("/user/{username}")
	public ResponseEntity<User> login(@PathVariable("username") String username) {
		User user = service.getUser(username);

		return ResponseEntity.ok(user);
	}

}

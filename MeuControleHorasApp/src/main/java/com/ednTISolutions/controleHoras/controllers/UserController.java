package com.ednTISolutions.controleHoras.controllers;

import com.ednTISolutions.controleHoras.models.User;
import com.ednTISolutions.controleHoras.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/usuario")
public class UserController {

	@Autowired
	private UserService service;


	@PostMapping
	public ResponseEntity<User> createAndUpdateUser(@RequestBody User user) {
		User newUser = service.createUser(user);
		return ResponseEntity.ok(newUser);
	}

	@GetMapping("/{username}")
	public ResponseEntity<User> login(@PathVariable("username") String username) {
		User user = service.getUser(username);
		return ResponseEntity.ok(user);
	}

}

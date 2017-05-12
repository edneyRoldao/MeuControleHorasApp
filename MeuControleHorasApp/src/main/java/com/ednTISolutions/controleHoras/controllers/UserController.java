package com.ednTISolutions.controleHoras.controllers;

import com.ednTISolutions.controleHoras.models.User;
import com.ednTISolutions.controleHoras.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/usuario")
public class UserController {

	@Autowired
	private UserService service;

	@PostMapping
	public ResponseEntity<User> createAndUpdateUser(@RequestBody User user) {
		User newUser = service.createUser(user);
		
		if(newUser == null)
			return ResponseEntity.status(HttpStatus.CONFLICT).body(null);
		
		return ResponseEntity.ok(newUser);
	}

}

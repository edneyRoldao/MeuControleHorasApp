package com.ednTISolutions.controleHoras.controllers;

import com.ednTISolutions.controleHoras.models.User;
import com.ednTISolutions.controleHoras.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/usuario")
public class UserController {

	@Autowired
	private UserService service;

	@PostMapping
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public ResponseEntity createAndUpdateUser(@RequestBody User user) {
		User newUser = service.createUser(user);
		
		if(newUser == null) {
			return new ResponseEntity("Already exists an user assigned for the e-mail: " + user.getEmail(), 
					HttpStatus.CONFLICT);
		}
		
		return ResponseEntity.ok(newUser);
	}

}

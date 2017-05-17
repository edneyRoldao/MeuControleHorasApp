package com.ednTISolutions.controleHoras.controllers;

import com.ednTISolutions.controleHoras.models.User;
import com.ednTISolutions.controleHoras.services.UserService;
import com.ednTISolutions.controleHoras.utils.TokenUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/usuario")
public class UserController {

	@Autowired
	private UserService service;

	@Autowired
	private TokenUtil tokenUtil;

	@PostMapping
	public ResponseEntity<User> createUserFirstStep(@RequestBody User user) {
		if(service.isUserCreatedBefore(user.getEmail()))
			return ResponseEntity.status(HttpStatus.CONFLICT).body(null);

		String token = tokenUtil.generateTokenFromNewUser(user);
        String url = service.createURLNewUser(token);

        // Send and check an e-mail confirmation at the same time to new user 
        if(!service.sendEmailToNewUser(user, url))
        	return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);        	

		return ResponseEntity.ok(user);
	}

	@GetMapping("/{token}")
	public ResponseEntity<User> createUserSecondStep(@PathVariable("token") String token) {
	    User user = tokenUtil.getNewUserFromToken(token);
        User newUser = service.createUser(user);

        // Check if user already exists
        if(newUser == null)
            return ResponseEntity.status(HttpStatus.CONFLICT).body(null);

		return ResponseEntity.ok(newUser);
	}

}

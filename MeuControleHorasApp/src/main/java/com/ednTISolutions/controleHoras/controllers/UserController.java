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
	public ResponseEntity<String> createUserFirstStep(@RequestBody User user) {
		if(service.isUserCreatedBefore(user.getEmail()))
			return ResponseEntity.status(HttpStatus.CONFLICT).body("user already created !");

		String token = tokenUtil.generateTokenFromNewUser(user);
        String url = service.createURLNewUser(token);

		// Send email here

		return ResponseEntity.ok("e-mail sent successfully !");
	}

	@PostMapping("/{token}")
	public ResponseEntity<User> createUserSecondStep(@PathVariable("token") String token) {
	    User user = tokenUtil.getNewUserFromToken(token);
        User newUser = service.createUser(user);

        if(newUser == null)
            return ResponseEntity.status(HttpStatus.CONFLICT).body(null);

		return ResponseEntity.ok(newUser);
	}

}

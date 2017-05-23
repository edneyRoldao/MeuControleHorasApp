package com.ednTISolutions.controleHoras.controllers;

import com.ednTISolutions.controleHoras.models.Token;
import com.ednTISolutions.controleHoras.models.User;
import com.ednTISolutions.controleHoras.services.TokenService;
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

	@Autowired
	private TokenService tokenService;

	@PostMapping
	public ResponseEntity<User> createUserFirstStep(@RequestBody User user) {
		if(service.isUserCreatedBefore(user.getEmail()))
			return ResponseEntity.status(HttpStatus.CONFLICT).body(null);

		String token = tokenUtil.generateTokenFromNewUser(user);
		Token tokenObj = service.saveConfirmationToken(token);

        if(!service.sendEmailToNewUser(user, tokenObj.getSerial()))
        	return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);        	

		return ResponseEntity.ok(user);
	}

	@GetMapping("/{serial}")
	public ResponseEntity<User> createUserSecondStep(@PathVariable("serial") String serial) {
		Token token = tokenService.retrieveTokenFromSerial(serial);

		if(token == null)
		    return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);

	    User user = tokenUtil.getNewUserFromToken(token.getToken());

	    if(user == null)
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);

        User newUser = service.createUser(user);
        tokenService.removeTokenNewUserValidation(serial);

        // Check if user already exists
        if(newUser == null)
            return ResponseEntity.status(HttpStatus.CONFLICT).body(null);

		return ResponseEntity.ok(newUser);
	}
	
	@SuppressWarnings("rawtypes")
	@PostMapping("/redefinirSenha")
	public ResponseEntity defineNewPassword(@RequestBody String email) {
		User user = service.findUserByEmail(email);
		
		if(user == null)
			return new ResponseEntity(HttpStatus.NOT_FOUND);

		String newPassword = email.split("@")[0];
		user.setPassword(newPassword);
		service.sendEmailNewPassword(user);
		service.saveNewPassowrd(user);
		
		return new ResponseEntity(HttpStatus.OK);
	}

}

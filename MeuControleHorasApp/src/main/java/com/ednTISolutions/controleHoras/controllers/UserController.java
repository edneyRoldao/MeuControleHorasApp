package com.ednTISolutions.controleHoras.controllers;

import com.ednTISolutions.controleHoras.models.NewUserTemp;
import com.ednTISolutions.controleHoras.models.User;
import com.ednTISolutions.controleHoras.security.utils.JwtTokenUtil;
import com.ednTISolutions.controleHoras.security.utils.SerialGenerator;
import com.ednTISolutions.controleHoras.services.NewUserTempService;
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

	@Autowired
	private JwtTokenUtil tokenUtil;

	@Autowired
	private NewUserTempService tokenService;

	@PostMapping
	public ResponseEntity<User> createUserFirstStep(@RequestBody User user) {
		if (service.isUserCreatedBefore(user.getUsername()))
			return ResponseEntity.status(HttpStatus.CONFLICT).body(null);

		String token = tokenUtil.generateTokenFromNewUser(user);
		NewUserTemp userTemp = service.saveConfirmationToken(token);

		if (!service.sendEmailToNewUser(user, userTemp.getSerial()))
			return ResponseEntity.status(HttpStatus.GATEWAY_TIMEOUT).body(null);

		return ResponseEntity.ok(user);
	}

	@GetMapping("/{serial}")
	public ResponseEntity<User> createUserLastStep(@PathVariable("serial") String serial) {
		NewUserTemp userTemp = tokenService.retrieveUserTempFromSerial(serial);

		if (userTemp == null)
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);

		User user = tokenUtil.getNewUserFromToken(userTemp.getToken());

		if (user == null)
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);

		if (service.isUserCreatedBefore(user.getUsername()))
			return ResponseEntity.status(HttpStatus.CONFLICT).body(null);

		User newUser = service.createUser(user);
		tokenService.deleteTemporaryUser(serial);

		return ResponseEntity.ok(newUser);
	}

	@SuppressWarnings("rawtypes")
	@PostMapping("/redefinirSenha")
	public ResponseEntity defineNewPassword(@RequestBody String username) {
		User user = service.findByUsername(username);

		if (user == null)
			return new ResponseEntity(HttpStatus.NOT_FOUND);

		String newPassword = SerialGenerator.generateSerial(6);
		user.setPassword(newPassword);

		if (!service.sendEmailNewPassword(user))
			return ResponseEntity.status(HttpStatus.GATEWAY_TIMEOUT).body(null);

		service.saveNewPassowrd(user);

		return new ResponseEntity(HttpStatus.OK);
	}

}

package com.ednTISolutions.controleHoras.controllers;

import com.ednTISolutions.controleHoras.models.NewUserToken;
import com.ednTISolutions.controleHoras.models.User;
import com.ednTISolutions.controleHoras.security.services.UserProfileService;
import com.ednTISolutions.controleHoras.security.utils.JwtTokenUtil;
import com.ednTISolutions.controleHoras.services.NewUserTokenService;
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
    private UserProfileService userProfileService;

    @Autowired
    private NewUserTokenService tokenService;

    @PostMapping
    public ResponseEntity<User> createUserFirstStep(@RequestBody User user) {
        if(service.isUserCreatedBefore(user.getUsername()))
            return ResponseEntity.status(HttpStatus.CONFLICT).body(null);

        String token = tokenUtil.generateTokenFromNewUser(user);
        NewUserToken tokenObj = service.saveConfirmationToken(token);

        if(!service.sendEmailToNewUser(user, tokenObj.getSerial()))
            return ResponseEntity.status(HttpStatus.GATEWAY_TIMEOUT).body(null);

        return ResponseEntity.ok(user);
    }

    @GetMapping("/{serial}")
    public ResponseEntity<User> createUserLastStep(@PathVariable("serial") String serial) {
        NewUserToken token = tokenService.retrieveTokenFromSerial(serial);

        if(token == null)
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);

        User user = tokenUtil.getNewUserFromToken(token.getToken());

        if(user == null)
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);

        if(service.isUserCreatedBefore(user.getUsername()))
            return ResponseEntity.status(HttpStatus.CONFLICT).body(null);

        User newUser = service.createUser(user);
        userProfileService.createNewProfile(newUser);
        tokenService.removeTokenNewUserValidation(serial);

        return ResponseEntity.ok(newUser);
    }

    @SuppressWarnings("rawtypes")
    @PostMapping("/redefinirSenha")
    public ResponseEntity defineNewPassword(@RequestBody String username) {
        User user = service.findByUsername(username);

        if(user == null)
            return new ResponseEntity(HttpStatus.NOT_FOUND);

        String newPassword = username.split("@")[0];
        user.setPassword(newPassword);

        if(!service.sendEmailNewPassword(user))
            return ResponseEntity.status(HttpStatus.GATEWAY_TIMEOUT).body(null);

        service.saveNewPassowrd(user);

        return new ResponseEntity(HttpStatus.OK);
    }

}

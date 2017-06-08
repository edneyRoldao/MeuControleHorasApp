package com.ednTISolutions.controleHoras.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("protected")
public class UserProfileController {

    @GetMapping
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<?> editProfile() {
    	System.out.println("########## Restrictions by using roles are working correctly ###########");
        return ResponseEntity.status(HttpStatus.OK).body(null);
    }

}
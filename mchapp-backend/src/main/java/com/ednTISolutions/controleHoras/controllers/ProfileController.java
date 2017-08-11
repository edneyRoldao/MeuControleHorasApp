package com.ednTISolutions.controleHoras.controllers;

import com.ednTISolutions.controleHoras.models.User;
import com.ednTISolutions.controleHoras.exceptions.ProfileUsernameEmptyException;
import com.ednTISolutions.controleHoras.exceptions.ThereIsNoUserException;
import com.ednTISolutions.controleHoras.models.Profile;
import com.ednTISolutions.controleHoras.services.ProfileService;
import com.ednTISolutions.controleHoras.security.utils.JwtTokenUtil;
import com.ednTISolutions.controleHoras.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("profile")
public class ProfileController {

    @Autowired
    private JwtTokenUtil jwtTokenUtil;

    @Autowired
    private ProfileService profileService;

    @Autowired
    private UserService userService;

    @PutMapping
    @PreAuthorize("hasRole('USER')")
    public ResponseEntity<Profile> updateProfile(@RequestBody Profile profile) {
        try {
			return ResponseEntity.status(HttpStatus.OK).body(profileService.update(profile));
		} catch (ProfileUsernameEmptyException e) {
			e.getMessage();
			return ResponseEntity.status(HttpStatus.PRECONDITION_FAILED).body(null);
		}
    }

    @GetMapping
    @PreAuthorize("hasRole('USER')")
    public ResponseEntity<Profile> getUserProfile(HttpServletRequest request) throws ThereIsNoUserException {
        String token = request.getHeader(JwtTokenUtil.TOKEN_HEADER);
        String username = jwtTokenUtil.getUsernameFromToken(token);
        User user = userService.findByUsername(username);
        
        if(user == null) {
        	String msg = "There is an unexpected error while trying to retrieve the User";
        	throw new ThereIsNoUserException(msg);        	
        }
        
    	Profile profile = profileService.find(user.getUsername());
        
    	if(profile == null)
    		profile = profileService.create(user);
        
        return ResponseEntity.status(HttpStatus.OK).body(profile);        	
    }

}
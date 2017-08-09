package com.ednTISolutions.controleHoras.controllers;

import com.ednTISolutions.controleHoras.models.User;
import com.ednTISolutions.controleHoras.exceptions.ThereIsNoUserException;
import com.ednTISolutions.controleHoras.models.Profile;
import com.ednTISolutions.controleHoras.services.ProfileService;
import com.ednTISolutions.controleHoras.security.utils.JwtTokenUtil;
import com.ednTISolutions.controleHoras.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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

    @GetMapping
    @PreAuthorize("hasRole('USER')")
    public ResponseEntity<Profile> getUserProfile(HttpServletRequest request) throws ThereIsNoUserException {
    	Profile profile = null;
    	
        String token = request.getHeader(JwtTokenUtil.TOKEN_HEADER);
        String username = jwtTokenUtil.getUsernameFromToken(token);
        User user = userService.findByUsername(username);
        
        if(user == null) {
        	throw new ThereIsNoUserException("There is an unexpected error while trying to retrieve the User");
        }
        
        if(user.getProfileId() != null) {
        	profile = profileService.getProfile(user.getProfileId());
            return ResponseEntity.status(HttpStatus.OK).body(profile);        	
        }
        
        profile = profileService.createProfile(user);
        userService.attachProfileIdFromUser(user);
        
        return ResponseEntity.status(HttpStatus.OK).body(profile);
    }

}
package com.ednTISolutions.controleHoras.controllers;

import com.ednTISolutions.controleHoras.models.UserProfile;
import com.ednTISolutions.controleHoras.security.services.UserProfileService;
import com.ednTISolutions.controleHoras.security.utils.JwtTokenUtil;
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
public class UserProfileController {

    @Autowired
    private JwtTokenUtil jwtTokenUtil;

    @Autowired
    private UserProfileService userProfileService;

    @GetMapping
    @PreAuthorize("hasRole('USER')")
    public ResponseEntity<UserProfile> getUserProfile(HttpServletRequest request) {
        String token = request.getHeader(JwtTokenUtil.TOKEN_HEADER);
        String username = jwtTokenUtil.getUsernameFromToken(token);
        UserProfile profile = userProfileService.getUserProfile(username);

        System.out.println("##################################################");
        System.out.println("##################################################");
        System.out.println(profile.getEmail());
        System.out.println(profile.getName());
        System.out.println("##################################################");
        System.out.println("##################################################");

        return ResponseEntity.status(HttpStatus.OK).body(profile);
    }

}
package com.ednTISolutions.controleHoras.controllers;

import com.ednTISolutions.controleHoras.models.User;
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
public class UserProfileController {

    @Autowired
    private JwtTokenUtil jwtTokenUtil;

    @Autowired
    private ProfileService userProfileService;

    @Autowired
    private UserService userService;

    @GetMapping
    @PreAuthorize("hasRole('USER')")
    public ResponseEntity<Profile> getUserProfile(HttpServletRequest request) {
        String token = request.getHeader(JwtTokenUtil.TOKEN_HEADER);
        User user = getUserFromToken(token);
        Profile profile = userProfileService.getUserProfile(user);

        return ResponseEntity.status(HttpStatus.OK).body(profile);
    }

    private User getUserFromToken(String token) {
        String username = jwtTokenUtil.getUsernameFromToken(token);
        return userService.findByUsername(username);
    }

}
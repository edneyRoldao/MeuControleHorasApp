package com.ednTISolutions.controleHoras.security.controllers;

import com.ednTISolutions.controleHoras.security.models.JwtAuthenticationRequest;
import com.ednTISolutions.controleHoras.security.models.JwtAuthenticationResponse;
import com.ednTISolutions.controleHoras.security.models.JwtUser;
import com.ednTISolutions.controleHoras.security.utils.JwtTokenUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@RestController
public class AuthenticationController {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private JwtTokenUtil jwtTokenUtil;

    @Autowired
    private UserDetailsService userDetailsService;

    @PostMapping("auth")
    public ResponseEntity<?> createAuthToken(@RequestBody JwtAuthenticationRequest req) {
        String token = null;

        try{
            UsernamePasswordAuthenticationToken userToken;
            userToken = new UsernamePasswordAuthenticationToken(req.getUsername(), req.getPassword());

            final Authentication authentication = authenticationManager.authenticate(userToken);

            SecurityContextHolder.getContext().setAuthentication(authentication);

            final UserDetails userDetails = userDetailsService.loadUserByUsername(req.getUsername());
            token = jwtTokenUtil.generateToken(userDetails);

        }catch (AuthenticationException e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(null);
        }

        return ResponseEntity.ok(new JwtAuthenticationResponse(token));
    }

    @GetMapping("refresh")
    public ResponseEntity<?> refreshAndGetAuthenticationToken(HttpServletRequest req) {
        String token = req.getHeader(JwtTokenUtil.TOKEN_HEADER);
        String username = jwtTokenUtil.getUsernameFromToken(token);
        JwtUser user = (JwtUser) userDetailsService.loadUserByUsername(username);

        if (jwtTokenUtil.canTokenBeRefreshed(token, user.getLastPasswordResetDate())) {
            String refreshedToken = jwtTokenUtil.refreshToken(token);
            return ResponseEntity.ok(new JwtAuthenticationResponse(refreshedToken));
        }

        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(null);
    }

}

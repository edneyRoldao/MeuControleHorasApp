package com.ednTISolutions.controleHoras.controllers;

import com.ednTISolutions.controleHoras.security.AuthenticationRequest;
import com.ednTISolutions.controleHoras.security.AuthenticationResponse;
import com.ednTISolutions.controleHoras.security.JwtUserDetails;
import com.ednTISolutions.controleHoras.utils.TokenUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by edneyroldao on 02/05/17.
 */
@RestController
@RequestMapping("/auth")
public class AuthenticationController {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private TokenUtil tokenUtil;

    @Autowired
    private UserDetailsService userDetailsService;

    @PostMapping
    public ResponseEntity<?> createAuthToken(@RequestBody AuthenticationRequest authReq)throws AuthenticationException {
        String token = null;
        UserDetails userDetails = null;
        UsernamePasswordAuthenticationToken user = null;

        try {
            user = new UsernamePasswordAuthenticationToken(authReq.getUsername(), authReq.getPassword());
            Authentication auth = authenticationManager.authenticate(user);
            SecurityContextHolder.getContext().setAuthentication(auth);
            userDetails = userDetailsService.loadUserByUsername(authReq.getUsername());
            token = tokenUtil.generateToken(userDetails);

        }catch (BadCredentialsException e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(null);
        }

        return ResponseEntity.ok(new AuthenticationResponse(token));
    }

    @GetMapping
    public ResponseEntity<?> refreshAndGetAuthenticationToken(HttpServletRequest request) {
        String token = request.getHeader(TokenUtil.TOKEN_HEADER);
        String username = tokenUtil.getUsernameFromToken(token);
        JwtUserDetails user = (JwtUserDetails) userDetailsService.loadUserByUsername(username);

        if(tokenUtil.canTokenBeRefreshed(token, user.getLastPasswordReset())) {
            String refreshedToken = tokenUtil.refreshToken(token);
            return ResponseEntity.ok(refreshedToken);
        }

        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(null);
    }

}

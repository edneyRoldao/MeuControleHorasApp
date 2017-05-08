package com.ednTISolutions.controleHoras.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by edneyroldao on 02/05/17.
 */
@RestController
@RequestMapping("/protected")
public class ProtectedController {

    @GetMapping
    @PreAuthorize("hasHole('ADMIN')")
    public ResponseEntity<?> getProtectedRequest() {
        return ResponseEntity.ok("greetings from admin protected method");
    }

}

package com.ednTISolutions.controleHoras.security;

import java.io.Serializable;

/**
 * Created by edneyroldao on 30/04/17.
 */
public class AuthenticationResponse implements Serializable {

    private static final long serialVersionUID = 1L;

    private String token;

    public AuthenticationResponse() {
        super();
    }

    public AuthenticationResponse(String token) {
        this.setToken(token);
    }

    public String getToken() {
        return this.token;
    }

    public void setToken(String token) {
        this.token = token;
    }

}

package com.ednTISolutions.controleHoras.tests;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

public class TestToken {

	private static final String SECRET = "testSecret";
	
	public static void main(String[] args) {
		
		Map<String, Object> claims = new HashMap<>();
		claims.put("sub", "edneyRoldao");
		
		String token = generateToken(claims, new Date(System.currentTimeMillis() + TimeUnit.DAYS.toMillis(1)));
		System.out.println(token);
		
		Claims claim = getClaimsFromToken(token);
		System.out.println(claim);
		
	}
	
    private static Claims getClaimsFromToken(String token) {
        Claims claims;
        try {
            claims = Jwts.parser()
                    .setSigningKey(SECRET)
                    .parseClaimsJws(token)
                    .getBody();
        } catch (Exception e) {
        	e.printStackTrace();
            claims = null;
        }
        return claims;
    }

	
    private static String generateToken(Map<String, Object> claims, Date date) {
        String token  = Jwts.builder()
                            .setClaims(claims)
                            .setExpiration(date)
                            .signWith(SignatureAlgorithm.HS512, SECRET)
                            .compact();
        return token;
    }
	
}

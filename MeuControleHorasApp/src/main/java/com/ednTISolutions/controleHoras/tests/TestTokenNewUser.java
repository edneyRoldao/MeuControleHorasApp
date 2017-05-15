package com.ednTISolutions.controleHoras.tests;

import com.ednTISolutions.controleHoras.models.User;
import com.ednTISolutions.controleHoras.utils.TokenUtil;

public class TestTokenNewUser {

	public static void main(String[] args) {
		
		TokenUtil tu = new TokenUtil();
		
		User u = new User();
		u.setUsername("edneyRoldao");
		u.setEmail("edney@mail.com");
		u.setPassword("abc123");
		
		String token = tu.generateTokenFromNewUser(u);
		System.out.println(token);
		
		User user = tu.getNewUserFromToken(token);
		
		System.out.println(user.toString());
	}
	
}

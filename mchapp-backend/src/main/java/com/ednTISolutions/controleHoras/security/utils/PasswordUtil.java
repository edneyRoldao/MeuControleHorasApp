package com.ednTISolutions.controleHoras.security.utils;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class PasswordUtil {

	public static String encodePassword(String password) {
		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
		return encoder.encode(password);
	}
	
	public static boolean arePasswordsEqual(String pass, String passFromDB) {
		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
		return encoder.matches(pass, passFromDB);
	}
	
	public static boolean arePasswordsNotEqual(String pass, String passFromDB) {
		return !arePasswordsEqual(pass, passFromDB);
	}
	
}

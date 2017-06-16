package com.ednTISolutions.controleHoras.security.utils;

import java.util.Random;

public class SerialGenerator {

	public static final String CHARACTERES = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
	public static Random random = new Random();

	public static String generateSerial(int size) {
		StringBuilder serial = new StringBuilder();

		for (int i = 0; i < size; i++) {
			char letter = CHARACTERES.charAt(random.nextInt(CHARACTERES.length()));
			serial.append(String.valueOf(letter));
		}

		return serial.toString();
	}

}

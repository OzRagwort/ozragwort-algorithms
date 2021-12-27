package com.ozragwort.code.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class q1718 {
	static class VigenereCipher {
		private static final String[] DOMAIN = new String[] {"", "a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l",
			"m", "n", "o", "p", "q", "r", "s", "t", "u", "v", "w", "x", "y", "z"};

		private String key;

		public VigenereCipher(String key) {
			this.key = key;
		}

		public String encrypt(String plain) {
			String roundKey = keySchedule(plain);
			StringBuilder cipher = new StringBuilder();
			for (int i = 0; i < plain.length(); i++) {
				String enc = encoding(plain.charAt(i), roundKey.charAt(i));
				cipher.append(enc);
			}
			return cipher.toString();
		}

		private String encoding(char plain, char key) {
			if (plain == ' ') {
				return " ";
			}
			int index = plain - key;
			if (index <= 0) {
				index += DOMAIN.length - 1;
			}
			return DOMAIN[index];
		}

		public String decrypt(String cipher) {
			String roundKey = keySchedule(cipher);
			StringBuilder plain = new StringBuilder();
			for (int i = 0; i < cipher.length(); i++) {
				String dec = decoding(cipher.charAt(i), roundKey.charAt(i));
				plain.append(dec);
			}
			return plain.toString();
		}

		private String decoding(char plain, char key) {
			if (plain == ' ') {
				return " ";
			}
			int index = plain + key;
			if (index >= DOMAIN.length) {
				index -= DOMAIN.length - 1;
			}
			return DOMAIN[index];
		}

		private String keySchedule(String text) {
			int length = text.length();
			StringBuilder rk = new StringBuilder();
			while (rk.length() < length) {
				rk.append(key);
			}
			return rk.substring(0, length);
		}
	}

	public void solution() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String plain = br.readLine();
		String key = br.readLine();
		VigenereCipher vigenereCipher = new VigenereCipher(key);

		String cipher = vigenereCipher.encrypt(plain);
		System.out.println(cipher);

		br.close();
	}
}

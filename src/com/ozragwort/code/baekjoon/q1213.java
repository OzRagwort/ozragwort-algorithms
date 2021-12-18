package com.ozragwort.code.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.TreeMap;

public class q1213 {
	class Palindrome {
		private static final String FAIL_MESSAGE = "I'm Sorry Hansoo";

		private TreeMap<Character, Integer> charCount = new TreeMap<>();

		public Palindrome() {
		}

		public void set(String string) {
			for (int i = 0; i < string.length(); i++) {
				char c = string.charAt(i);
				if (charCount.containsKey(c)) {
					charCount.put(c, charCount.get(c) + 1);
					continue;
				}
				charCount.put(c, 1);
			}
		}

		// 240ms
		public boolean isPalindrome() {
			return charCount.values()
				.stream()
				.filter(this::isOdd)
				.count() <= 1;
		}

		// 76ms
		// public boolean isPalindrome() {
		// 	int oddCount = 0;
		// 	for (Character character : charCount.keySet()) {
		// 		if (isOdd(charCount.get(character))) {
		// 			oddCount++;
		// 		}
		// 	}
		// 	return oddCount <= 1;
		// }

		private boolean isOdd(Integer count) {
			return count % 2 == 1;
		}

		public String getPalindrome() {
			if (isPalindrome()) {
				return makePalindrome();
			}
			return FAIL_MESSAGE;
		}

		private String makePalindrome() {
			StringBuilder builder = new StringBuilder();
			String mid = "";

			for (char key : charCount.keySet()) {
				int count = charCount.get(key);
				if (isOdd(count)) {
					mid = Character.toString(key);
				}
				for (int i = 0; i < count / 2; i++) {
					builder.append(key);
				}
			}

			return builder.toString()
				+ mid
				+ builder.reverse().toString();
		}
	}

	public void solution() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String N = br.readLine();
		Palindrome palindrome = new Palindrome();
		palindrome.set(N);
		System.out.println(palindrome.getPalindrome());

		br.close();
	}
}

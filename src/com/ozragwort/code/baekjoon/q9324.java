package com.ozragwort.code.baekjoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashMap;
import java.util.Map;

public class q9324 {
	static class Encoder {
		private static final Map<String, Integer> COUNT = new HashMap<>();
		private static final String[] ALPHABET = new String[] {"A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K",
			"L", "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z"};
		private static final String OK = "OK";
		private static final String FAKE = "FAKE";

		public Encoder() {
			for (String alphabet : ALPHABET) {
				COUNT.put(alphabet, 0);
			}
		}

		public String check(String message) {
			Map<String, Integer> count = new HashMap<>(COUNT);
			int i = 0;
			while (i < message.length()) {
				String s = message.substring(i, i + 1);
				count.put(s, count.get(s) + 1);
				if (count.get(s) == 3) {
					count.put(s, 0);
					i++;
					if (message.length() <= i || !message.substring(i, i + 1).equals(s)) {
						return FAKE;
					}
				}
				i++;
			}
			return OK;
		}
	}

	public void solution() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		Encoder encoder = new Encoder();
		int N = Integer.parseInt(br.readLine());
		for (int i = 0; i < N; i++) {
			String M = br.readLine();
			bw.write(encoder.check(M));
			bw.newLine();
		}

		bw.flush();
		bw.close();
		br.close();
	}
}

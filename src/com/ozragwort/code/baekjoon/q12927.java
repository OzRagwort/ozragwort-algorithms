package com.ozragwort.code.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class q12927 {
	static class Bulb {
		private static final char YES = 'Y';
		private boolean[] bulbs;

		public Bulb(String bulbs) {
			this.bulbs = new boolean[bulbs.length() + 1];
			for (int i = 0; i < bulbs.length(); i++) {
				char c = bulbs.charAt(i);
				if (c == YES) {
					this.bulbs[i + 1] = true;
				}
			}
		}

		public int turnOffAll() {
			int count = 0;
			for (int i = 1; i < bulbs.length; i++) {
				if (bulbs[i]) {
					count++;
					pushSwitch(i);
				}
			}
			return count;
		}

		private void pushSwitch(int index) {
			for (int i = index; i < bulbs.length; i += index) {
				bulbs[i] ^= true;
			}
		}
	}

	public void solution() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		Bulb bulb = new Bulb(br.readLine());
		int count = bulb.turnOffAll();
		System.out.println(count);

		br.close();
	}
}

package com.ozragwort.code.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class q14495 {
	static class Fibonacci {
		private static final int MAX_SIZE = 116;

		private Long[] fibonacci = new Long[MAX_SIZE + 1];

		public Fibonacci() {
			fibonacci[1] = 1L;
			fibonacci[2] = 1L;
			fibonacci[3] = 1L;
		}

		public long get(int i) {
			if (fibonacci[i] == null) {
				fibonacci[i] = get(i - 1) + get(i - 3);
			}
			return fibonacci[i];
		}
	}

	public void solution() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		Fibonacci fibonacci = new Fibonacci();
		int n = Integer.parseInt(br.readLine());
		System.out.println(fibonacci.get(n));

		br.close();
	}
}

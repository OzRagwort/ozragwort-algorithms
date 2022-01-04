package com.ozragwort.code.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class q13699 {
	static class Expression {
		private static final int SIZE = 36;

		private long[] t = new long[SIZE];

		public Expression() {
			t[0] = 1;
			for (int n = 1; n < SIZE; n++) {
				calcByN(n);
			}
		}

		private void calcByN(int n) {
			for (int i = 0; i < n / 2; i++) {
				t[n] += t[i] * t[n - i - 1];
			}
			t[n] *= 2;
			if (n % 2 == 1) {
				t[n] += t[n / 2] * t[n / 2];
			}
		}

		public long get(int n) {
			return t[n];
		}
	}

	public void solution() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		Expression expression = new Expression();
		int n = Integer.parseInt(br.readLine());
		long result = expression.get(n);
		System.out.println(result);

		br.close();
	}
}

package com.ozragwort.code.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class q11055 {
	static class Sequence {
		private int[] array;

		public Sequence(int[] array) {
			this.array = array;
		}

		public int getMaxIncrease() {
			int[] dp = new int[array.length];
			System.arraycopy(array, 0, dp, 0, array.length);

			for (int i = 0; i < array.length; i++) {
				for (int j = 0; j <= i; j++) {
					if (array[j] < array[i]) {
						dp[i] = Math.max(dp[i], dp[j] + array[i]);
					}
				}
			}
			return Arrays.stream(dp)
				.max()
				.getAsInt();
		}
	}

	public void solution() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		StringTokenizer stk = new StringTokenizer(br.readLine());
		int[] array = new int[N];
		for (int i = 0; i < N; i++) {
			array[i] = Integer.parseInt(stk.nextToken());
		}

		Sequence sequence = new Sequence(array);
		System.out.println(sequence.getMaxIncrease());

		br.close();
	}
}

package com.ozragwort.code.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class q10819 {
	static class Difference {
		public Difference() {
		}

		public int getMax(int[] numbers) {
			boolean[] visit = new boolean[numbers.length];
			int[] buffer = new int[numbers.length];
			return dfs(numbers, buffer, visit, 0, 0);
		}

		private int dfs(int[] numbers, int[] buffer, boolean[] visit, int depth, int max) {
			if (depth == numbers.length) {
				return Math.max(max, calc(buffer));
			}
			for (int i = 0; i < numbers.length; i++) {
				if (visit[i]) {
					continue;
				}
				buffer[depth] = numbers[i];
				visit[i] = true;
				max = dfs(numbers, buffer, visit, depth + 1, max);
				visit[i] = false;
			}
			return max;
		}

		private int calc(int[] numbers) {
			int result = 0;
			for (int i = 0; i < numbers.length - 1; i++) {
				result += Math.abs(numbers[i] - numbers[i + 1]);
			}
			return result;
		}
	}

	public void solution() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());
		StringTokenizer stk = new StringTokenizer(br.readLine());
		int[] numbers = new int[N];
		for (int i = 0; i < N; i++) {
			numbers[i] = Integer.parseInt(stk.nextToken());
		}
		Difference difference = new Difference();
		System.out.println(difference.getMax(numbers));

		br.close();
	}
}

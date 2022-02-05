package com.ozragwort.code.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class q1890 {
	static class Jump {
		private static final String ERROR_MESSAGE = "범위가 잘못되었음";

		private int[][] table;

		public Jump(int[][] table) {
			this.table = table;
		}

		public long getNumberOfPath() {
			int R = table.length;
			int C = table[0].length;
			if (valid(R, C)) {
				throw new IllegalArgumentException(ERROR_MESSAGE);
			}
			long[][] dp = new long[R][C];
			calcPath(dp, R, C);
			return dp[R - 1][C - 1];
		}

		private void calcPath(long[][] dp, int r, int c) {
			dp[0][0] = 1;
			for (int i = 0; i < r; i++) {
				for (int j = 0; j < c; j++) {
					if (isGoal(i, j)) {
						return;
					}
					if (i + table[i][j] < r) {
						dp[i + table[i][j]][j] += dp[i][j];
					}
					if (j + table[i][j] < c) {
						dp[i][j + table[i][j]] += dp[i][j];
					}
				}
			}
		}

		private boolean isGoal(int r, int c) {
			return r == table.length - 1 && c == table[0].length - 1;
		}

		private boolean valid(int r, int c) {
			if (r < 0 || c < 0 || table.length < r || table[0].length < c) {
				return true;
			}
			return false;
		}
	}

	public void solution() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());

		int[][] array = new int[N][N];
		for (int i = 0; i < N; i++) {
			StringTokenizer stk = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				array[i][j] = Integer.parseInt(stk.nextToken());
			}
		}

		Jump jump = new Jump(array);
		System.out.println(jump.getNumberOfPath());

		br.close();
	}
}

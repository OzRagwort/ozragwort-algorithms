package com.ozragwort.code.baekjoon;

import java.io.*;

public class q2602 {

	public void solution() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String scroll = br.readLine();
		String[] loads = new String[2];
		loads[0] = br.readLine();
		loads[1] = br.readLine();
		int[][][] dp = new int[2][loads[0].length()][scroll.length()];
		int result = 0;

		for (int i = 0; i < loads[0].length(); i++) {
			for (int si = 0; si < scroll.length(); si++) {
				char scrollChar = scroll.charAt(si);
				if (loads[0].charAt(i) == scrollChar) {
					check(i, 0, si, dp);
				}
				if (loads[1].charAt(i) == scrollChar) {
					check(i, 1, si, dp);
				}
			}
		}

		for (int i = 0; i < loads[0].length(); i++) {
			result += dp[0][i][scroll.length() - 1];
			result += dp[1][i][scroll.length() - 1];
		}

		System.out.println(result);

		br.close();
	}

	private int[][][] check(int i, int li, int si, int[][][] dp) {
		if (si == 0) {
			dp[li][i][si] = 1;
			return dp;
		}
		for (int p = 0 ; p < i ; p++) {
			dp[li][i][si] += dp[(li + 1) % 2][p][si - 1];
		}
		return dp;
	}

}

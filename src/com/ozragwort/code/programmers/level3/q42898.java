package com.ozragwort.code.programmers.level3;

public class q42898 {
    public int solution(int m, int n, int[][] puddles) {
        int[][] dp = new int[n + 1][m + 1];
        boolean[][] water = new boolean[n + 1][m + 1];
        int MOD = 1000000007;

        for (int i = 0 ; i < puddles.length ; i++) {
            water[puddles[i][1]][puddles[i][0]] = true;
        }

        dp[0][1] = 1;
        for (int i = 1 ; i <= n ; i++) {
            for (int j = 1 ; j <= m ; j++) {
                if (water[i][j]) {
                    continue;
                } else {
                    dp[i][j] = (dp[i - 1][j] + dp[i][j - 1]) % MOD;
                }
            }
        }

        return dp[n][m];
    }
}

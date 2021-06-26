package com.ozragwort.code.programmers.level3;

public class q12900 {
    public int solution(int n) {
        int[] dp = new int[n + 1];
        int MOD = 1000000007;

        dp[0] = dp[1] = 1;
        for (int i = 2 ; i <= n ; i++) {
            dp[i] = (dp[i - 1] + dp[i - 2]) % MOD;
        }

        return dp[n];
    }
}

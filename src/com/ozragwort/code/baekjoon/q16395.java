package com.ozragwort.code.baekjoon;

import java.io.*;
import java.util.StringTokenizer;

public class q16395 {
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stk = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(stk.nextToken());
        int k = Integer.parseInt(stk.nextToken());
        int[][] dp = new int[n + 1][k + 1];

        dp[1][1] = 1;
        for (int i = 2 ; i <= n ; i++) {
            for (int j = 1 ; j <= k ; j++) {
                dp[i][j] = dp[i - 1][j - 1] + dp[i - 1][j];
            }
        }

        System.out.print(dp[n][k]);
    }
}

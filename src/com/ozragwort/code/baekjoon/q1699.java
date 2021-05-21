package com.ozragwort.code.baekjoon;

import java.io.*;

public class q1699 {
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] dp = new int[N + 1];

        for (int i = 1 ; i <= N ; i++) {
            dp[i] = Integer.MAX_VALUE;
            for (int j = 1 ; j * j <= i ; j++) {
                dp[i] = Math.min(dp[i], dp[i - (j * j)] + 1);
            }
        }

        System.out.print(dp[N]);
    }
}

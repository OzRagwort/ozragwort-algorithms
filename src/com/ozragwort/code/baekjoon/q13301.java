package com.ozragwort.code.baekjoon;

import java.io.*;

public class q13301 {
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        long[] dp = new long[80];

        dp[0] = dp[1] = 1;
        for (int i = 2 ; i < N ; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }

        if (N == 1) {
            System.out.print(4);
        } else {
            System.out.print(dp[N - 1] * 4 + dp[N - 2] * 2);
        }
    }
}

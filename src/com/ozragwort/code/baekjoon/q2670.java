package com.ozragwort.code.baekjoon;

import java.io.*;

public class q2670 {
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        double[] num = new double[N];
        double[] dp = new double[N];
        double max = Integer.MIN_VALUE;

        for (int i = 0 ; i < N ; i++) {
            num[i] = Double.parseDouble(br.readLine());
        }

        dp[0] = num[0];
        for (int i = 1 ; i < N ; i++) {
            dp[i] = Math.max(dp[i - 1] * num[i], num[i]);
            if (max < dp[i]) {
                max = dp[i];
            }
        }

        System.out.format("%.3f", max);
    }
}

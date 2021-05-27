package com.ozragwort.code.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class q11052 {
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] P = new int[N + 1];
        int[] dp = new int[N + 1];

        StringTokenizer stk = new StringTokenizer(br.readLine());
        for (int i = 1 ; i <= N ; i++) {
            P[i] = Integer.parseInt(stk.nextToken());
        }

        for (int i = 1 ; i <= N ; i++) {
            for (int j = 1 ; j <= i ; j++) {
                dp[i] = Math.max(dp[i], dp[i - j] + P[j]);
            }
        }

        System.out.print(dp[N]);
    }
}

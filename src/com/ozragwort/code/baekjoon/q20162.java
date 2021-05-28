package com.ozragwort.code.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class q20162 {
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] grade = new int[N + 1];
        int[] dp = new int[N + 1];
        int max = 0;

        for (int i = 1 ; i <= N ; i++) {
            grade[i] = Integer.parseInt(br.readLine());
        }

        for (int i = 1 ; i <= N ; i++) {
            for (int j = 0 ; j < i ; j++) {
                if (grade[j] < grade[i]) {
                    dp[i] = Math.max(dp[i], dp[j] + grade[i]);
                }
            }
            if (max < dp[i]) {
                max = dp[i];
            }
        }

        System.out.print(max);
    }
}

package com.ozragwort.code.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class q11722 {
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stk;
        int N = Integer.parseInt(br.readLine());
        int[] seq = new int[N];
        int[] dp = new int[N];
        int max = 0;

        stk = new StringTokenizer(br.readLine());
        for (int i = 0 ; i < N ; i++) {
            seq[i] = Integer.parseInt(stk.nextToken());
        }

        // 위 반복문에 그대로 합쳐도 문제없음
        for (int i = 0 ; i < N ; i++) {
            dp[i] = 1;
            for (int j = 0 ; j < i ; j++) {
                if (seq[i] < seq[j]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
            if (max < dp[i]) {
                max = dp[i];
            }
        }

        System.out.print(max);
    }
}

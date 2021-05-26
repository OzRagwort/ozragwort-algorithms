package com.ozragwort.code.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class q11727 {
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] dp = new int[N];

        if (N >= 1) {
            dp[0] = 1;
        }
        if (N >= 2) {
            dp[1] = 3;
        }
        if (N >= 3) {
            for (int i = 2 ; i < N ; i++) {
                dp[i] = ((dp[i - 2] * 2) + dp[i - 1]) % 10007;
            }
        }

        System.out.print(dp[N - 1]);

    }
}

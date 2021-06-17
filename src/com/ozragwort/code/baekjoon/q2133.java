package com.ozragwort.code.baekjoon;

import java.io.*;

public class q2133 {
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] dp = new int[N + 1];
        dp[0] = 1;

        if (N % 2 == 0) {
            for (int i = 2 ; i <= N ; i+=2) {
                int v = 0;
                for (int j = 0 ; j <= i - 4 ; j+=2) {
                    v += dp[j];
                }
                dp[i] = (dp[i - 2] * 3) + (v * 2);
            }

            System.out.print(dp[N]);
        } else {
            System.out.print("0");
        }
    }
}

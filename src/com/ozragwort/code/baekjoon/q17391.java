package com.ozragwort.code.baekjoon;

import java.io.*;
import java.util.StringTokenizer;

public class q17391 {
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stk = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(stk.nextToken());
        int M = Integer.parseInt(stk.nextToken());
        int[][] item = new int[N][M];
        int[][] dp = new int[N][M];

        for (int i = 0 ; i < N ; i++) {
            stk = new StringTokenizer(br.readLine());
            for (int j = 0 ; j < M ; j++) {
                item[i][j] = Integer.parseInt(stk.nextToken());
                dp[i][j] = Integer.MAX_VALUE;
            }
        }

        dp[0][0] = 0;
        for (int i = 0 ; i < N ; i++) {
            for (int j = 0 ; j < M ; j++) {
                for (int d = 1 ; d <= item[i][j] ; d++) {
                    if (i + d < N) {
                        dp[i + d][j] = Math.min(dp[i + d][j], dp[i][j] + 1);
                    }
                    if (j + d < M) {
                        dp[i][j + d] = Math.min(dp[i][j + d], dp[i][j] + 1);
                    }
                }
            }
        }

        System.out.print(dp[N - 1][M - 1]);
    }
}

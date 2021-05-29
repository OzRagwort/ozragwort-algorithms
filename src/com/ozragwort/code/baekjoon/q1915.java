package com.ozragwort.code.baekjoon;

import java.io.*;
import java.util.StringTokenizer;

public class q1915 {
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stk = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(stk.nextToken());
        int M = Integer.parseInt(stk.nextToken());
        boolean[][] table = new boolean[N + 1][M + 1];
        int[][] dp = new int[N + 1][M + 1];
        int max = 0;

        for (int i = 1 ; i <= N ; i++) {
            String s = br.readLine();
            for (int j = 1 ; j <= M ; j++) {
                if (s.charAt(j - 1) == '1') {
                    table[i][j] = true;
                    dp[i][j] = 1;
                }
            }
        }

        for (int i = 1 ; i <= N ; i++) {
            for (int j = 1 ; j <= M ; j++) {
                if (table[i][j] && table[i - 1][j - 1]) {
                    dp[i][j] = Math.min(Math.min(dp[i - 1][j], dp[i][j - 1]), dp[i - 1][j - 1]) + 1;
                }
                if (max < dp[i][j]) {
                    max = dp[i][j];
                }
            }
        }

        System.out.print(max * max);
    }
}

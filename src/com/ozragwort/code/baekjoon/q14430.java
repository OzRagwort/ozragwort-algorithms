package com.ozragwort.code.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class q14430 {
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stk = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(stk.nextToken());
        int M = Integer.parseInt(stk.nextToken());
        boolean[][] table = new boolean[N + 1][M + 1];
        int[][] dp = new int[N + 1][M + 1];

        for (int i = 1 ; i <= N ; i++) {
            stk = new StringTokenizer(br.readLine());
            for (int j = 1 ; j <= M ; j++) {
                if (stk.nextToken().equals("1")) {
                    table[i][j] = true;
                }
            }
        }

        for (int i = 1 ; i <= N ; i++) {
            for (int j = 1 ; j <= M ; j++) {
                dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                if (table[i][j]) {
                    dp[i][j]++;
                }
            }
        }

        System.out.print(dp[N][M]);

    }
}

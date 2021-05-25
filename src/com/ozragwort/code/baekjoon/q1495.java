package com.ozragwort.code.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class q1495 {
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stk = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(stk.nextToken());
        int S = Integer.parseInt(stk.nextToken());
        int M = Integer.parseInt(stk.nextToken());
        int[] V = new int[N + 1];
        boolean[][] dp = new boolean[N + 1][M + 1];
        stk = new StringTokenizer(br.readLine());

        for (int i = 1 ; i <= N ; i++) {
            V[i] = Integer.parseInt(stk.nextToken());
        }

        dp[0][S] = true;

        for (int i = 1 ; i <= N ; i++) {
            for (int j = 0 ; j <= M ; j++) {
                if (dp[i - 1][j]) {
                    if (j + V[i] <= M) {
                        dp[i][j + V[i]] = true;
                    }
                    if (j - V[i] >= 0) {
                        dp[i][j - V[i]] = true;
                    }
                }
            }
        }

        int result = -1;
        for (int i = M ; i >= 0 ; i--) {
            if (dp[N][i]) {
                result = i;
                break;
            }
        }

        System.out.print(result);
    }
}

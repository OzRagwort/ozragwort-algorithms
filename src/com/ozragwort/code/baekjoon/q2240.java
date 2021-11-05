package com.ozragwort.code.baekjoon;

import java.io.*;
import java.util.*;

public class q2240 {

    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer stk = new StringTokenizer(br.readLine());
        int T = Integer.parseInt(stk.nextToken());
        int W = Integer.parseInt(stk.nextToken());

        int[] drop = new int[T + 1];
        int[][][] dp = new int[3][T + 1][W + 2];

        for (int i = 1 ; i <= T ; i++) {
            drop[i] = Integer.parseInt(br.readLine());
        }

        if (drop[1] == 1) {
            dp[1][1][1] = 1;
        } else {
            dp[2][1][2] = 1;
        }

        for (int i = 2 ; i <= T ; i++) {
            for (int j = 1 ; j <= W + 1 ; j++) {
                if (drop[i] == 1) {
                    dp[1][i][j] = Math.max(dp[1][i - 1][j] + 1, dp[2][i - 1][j - 1] + 1);
                    dp[2][i][j] = Math.max(dp[2][i - 1][j], dp[1][i - 1][j - 1]);
                } else {
                    dp[1][i][j] = Math.max(dp[1][i - 1][j], dp[2][i - 1][j - 1]);
                    dp[2][i][j] = Math.max(dp[2][i - 1][j] + 1, dp[1][i - 1][j - 1] + 1);
                }
            }
        }

        int max = 0;
        for (int i = 1 ; i <= W + 1 ; i++) {
            max = Math.max(max, Math.max(dp[1][T][i], dp[2][T][i]));
        }

        System.out.println(max);

        bw.flush();
        bw.close();
        br.close();
    }

}

package com.ozragwort.code.baekjoon;

import java.io.*;
import java.util.StringTokenizer;

public class q9465 {
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer stk;
        int T = Integer.parseInt(br.readLine());
        int[][] point;

        for (int i = 0 ; i < T ; i++) {
            int n = Integer.parseInt(br.readLine());
            point = new int[n][2];

            for (int k = 0 ; k < 2 ; k++) {
                stk = new StringTokenizer(br.readLine());
                for (int j = 0 ; j < n ; j++) {
                    point[j][k] = Integer.parseInt(stk.nextToken());
                }
            }

            bw.write(getMaxScore(point, n) + "\n");
        }

        bw.flush();
        bw.close();
        br.close();
    }

    public int getMaxScore(int[][] point, int n) {
        int[][] dp = new int[n][2];

        if (n >= 1) {
            dp[0] = point[0];
        }
        if (n >= 2) {
            dp[1][0] = dp[0][1] + point[1][0];
            dp[1][1] = dp[0][0] + point[1][1];
        }
        if (n >= 3) {
            for (int i = 2 ; i < n ; i++) {
                dp[i][0] = Math.max(dp[i - 1][1], dp[i - 2][1]) + point[i][0];
                dp[i][1] = Math.max(dp[i - 1][0], dp[i - 2][0]) + point[i][1];
            }
        }

        return Math.max(dp[n - 1][0], dp[n - 1][1]);
    }
}

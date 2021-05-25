package com.ozragwort.code.baekjoon;

import java.io.*;

public class q15990 {

    long[][] dp = new long[100001][3];
    int dpIndex = 0;

    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int T = Integer.parseInt(br.readLine());

        dp[1][0] = 1;
        dp[1][1] = 0;
        dp[1][2] = 0;
        dp[2][0] = 0;
        dp[2][1] = 1;
        dp[2][2] = 0;
        dp[3][0] = 1;
        dp[3][1] = 1;
        dp[3][2] = 1;
        dpIndex = 4;

        for (int i = 0 ; i < T ; i++) {
            int n = Integer.parseInt(br.readLine());
            if (dp[n][0] == 0 && dp[n][1] == 0 && dp[n][2] == 0) {
                calc(n);
            }
            bw.write((dp[n][0] + dp[n][1] + dp[n][2]) % 1000000009 + "\n");
        }

        bw.flush();
    }

    public void calc(int n) {
        for (int i = dpIndex ; i <= n ; i++) {
            dp[i][0] = (dp[i - 1][1] + dp[i - 1][2]) % 1000000009;
            dp[i][1] = (dp[i - 2][0] + dp[i - 2][2]) % 1000000009;
            dp[i][2] = (dp[i - 3][0] + dp[i - 3][1]) % 1000000009;
        }
        dpIndex = n + 1;
    }
}

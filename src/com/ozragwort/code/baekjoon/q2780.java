package com.ozragwort.code.baekjoon;

import java.io.*;

public class q2780 {

    int[][] dp = new int[1001][10];
    int[][] wv = new int[][]{{7}, {2, 4}, {1, 3, 5}, {2, 6}, {1, 5, 7}, {2, 4, 6, 8}, {3, 5, 9}, {4, 8, 0}, {5, 7, 9}, {6, 8}};

    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int T = Integer.parseInt(br.readLine());
        int result = 0;

        for (int i = 0 ; i < 10 ; i++) {
            dp[1][i] = 1;
        }

        for (int i = 0 ; i < T ; i++) {
            int N = Integer.parseInt(br.readLine());
            if (dp[N][0] == 0) {
                password(N);
            }
            for (int j = 0 ; j < 10 ; j++) {
                result += dp[N][j];
            }
            bw.write((result % 1234567) + "\n");
            result = 0;
        }

        bw.flush();
        bw.close();
        br.close();
    }

    public void password(int N) {
        if (dp[N - 1][0] == 0) {
            password(N - 1);
        }
        for (int i = 0 ; i < 10 ; i++) {
            for (int w : wv[i]) {
                dp[N][i] += dp[N - 1][w];
            }
            dp[N][i] %= 1234567;
        }
    }
}

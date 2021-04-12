package com.ozragwort.code.baekjoon;

import java.io.*;

public class q9251 {

    char[] N1;
    char[] N2;
    int[][] dp;

    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        N1 = br.readLine().toCharArray();
        N2 = br.readLine().toCharArray();
        dp = new int[N1.length][N2.length];

        for (int i = 0 ; i < N1.length ; i++) {
            for (int j = 0 ; j < N2.length ; j++) {
                dp[i][j] = lcs(i, j, false);
            }
        }

        bw.write(Integer.toString(dp[N1.length-1][N2.length-1]));

        bw.flush();
        bw.close();
        br.close();
    }

    public int lcs(int x, int y, boolean check) {
        if (x < 0 || y < 0) {
            return 0;
        } else if (check) {
            return dp[x][y];
        } else {
            if (N1[x] == N2[y]) {
                dp[x][y] = lcs(x-1, y-1, true) + 1;
            } else {
                dp[x][y] = Math.max(lcs(x, y-1, true), lcs(x-1, y, true));
            }
            return dp[x][y];
        }
    }
}

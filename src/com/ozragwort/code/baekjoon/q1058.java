package com.ozragwort.code.baekjoon;

import java.io.*;

public class q1058 {
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        boolean[][] friend = new boolean[N][N];
        boolean[][] dp = new boolean[N][N];
        int max = 0;

        for (int i = 0 ; i < N ; i++) {
            String s = br.readLine();
            for (int j = 0 ; j < N ; j++) {
                if (s.charAt(j) == 'Y') {
                    friend[i][j] = true;
                }
            }
        }

        for (int i = 0 ; i < N ; i++) {
            for (int j = 0 ; j < N ; j++) {
                dp[i][j] |= friend[i][j];
                for (int k = 0 ; k < N ; k++) {
                    if (i != j && i != k && j != k) {
                        dp[i][k] |= friend[i][j] && friend[j][k];
                    }
                }
            }
        }

        for (int i = 0 ; i < N ; i++) {
            int counter = 0;
            for (int j = 0 ; j < N ; j++) {
                if (dp[i][j]) {
                    counter++;
                }
            }
            if (max < counter) {
                max = counter;
            }
        }

        System.out.print(max);
    }
}

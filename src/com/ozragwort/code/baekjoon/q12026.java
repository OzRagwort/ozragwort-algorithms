package com.ozragwort.code.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class q12026 {
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] block = new int[N];
        int[][] dp = new int[N][2];

        String in = br.readLine();
        for (int i = 0 ; i < N ; i++) {
            char c = in.charAt(i);
            if (c == 'B') {
                block[i] = 0;
            } else if (c == 'O') {
                block[i] = 1;
            } else {
                block[i] = 2;
            }
        }

        for (int i = 1 ; i < N ; i++) {
            dp[i][0] = Integer.MAX_VALUE;
            dp[i][1] = -1;
            for (int j = 0 ; j < i ; j++) {
                if (dp[j][1] == (block[i] + 2) % 3) {
                    int dist = (i - j) * (i - j);
                    dp[i][0] = Math.min(dp[i][0], dp[j][0] + dist);
                    dp[i][1] = block[i];
                }
            }
        }

        if (dp[N - 1][1] == -1) {
            System.out.print("-1");
        } else {
            System.out.print(dp[N - 1][0]);
        }
    }
}

package com.ozragwort.code.baekjoon;

import java.io.*;

public class q12849 {

    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        long[] dp = new long[8];
        int[][] moves = new int[][]{
                {0, 1, 1, 0, 0, 0, 0, 0},
                {1, 0, 1, 1, 0, 0, 0, 0},
                {1, 1, 0, 1, 1, 0, 0, 0},
                {0, 1, 1, 0, 1, 1, 0, 0},
                {0, 0, 1, 1, 0, 1, 1, 0},
                {0, 0, 0, 1, 1, 0, 0, 1},
                {0, 0, 0, 0, 1, 0, 0, 1},
                {0, 0, 0, 0, 0, 1, 1, 0}
        };

        int D = Integer.parseInt(br.readLine());

        dp[0] = 1;
        long[] next = new long[8];
        for (int d = 0 ; d < D ; d++) {
            next = new long[8];
            for (int i = 0 ; i < 8 ; i++) {
                next = move(next, moves[i], dp[i]);
            }
            System.arraycopy(next, 0, dp, 0, 8);
        }

        int result = (int) dp[0];

        System.out.println(result);

        br.close();
    }

    public long[] move(long[] next, int[] move, long c) {
        for (int i = 0 ; i < 8 ; i++) {
            next[i] += move[i] * c;
            next[i] %= 1000000007;
        }

        return next;
    }

}

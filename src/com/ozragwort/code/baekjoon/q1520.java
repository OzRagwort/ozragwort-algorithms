package com.ozragwort.code.baekjoon;

import java.io.*;
import java.util.*;

public class q1520 {

    int[][] matrix;
    Integer[][] dp;
    int M, N;

    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer stk = new StringTokenizer(br.readLine());
        M = Integer.parseInt(stk.nextToken());
        N = Integer.parseInt(stk.nextToken());
        matrix = new int[M][N];
        dp = new Integer[M][N];
        int counter = 0;

        for (int i = 0 ; i < M ; i++) {
            stk = new StringTokenizer(br.readLine());
            for (int j = 0 ; j < N ; j++) {
                matrix[i][j] = Integer.parseInt(stk.nextToken());
            }
        }

        dp[M - 1][N - 1] = 1;
        counter = routeCheck(0, 0);

        bw.write(Integer.toString(counter));

        bw.flush();
        bw.close();
        br.close();
    }

    public int routeCheck(int h, int w) {
        if (dp[h][w] == null) {
            dp[h][w] = 0;
            if ((w - 1 >= 0) && matrix[h][w] > matrix[h][w - 1]) {
                dp[h][w] += routeCheck(h, w - 1);
            } if ((w + 1 <= N - 1) && matrix[h][w] > matrix[h][w + 1]) {
                dp[h][w] += routeCheck(h, w + 1);
            } if ((h - 1 >= 0) && matrix[h][w] > matrix[h - 1][w]) {
                dp[h][w] += routeCheck(h - 1, w);
            } if ((h + 1 <= M - 1) && matrix[h][w] > matrix[h + 1][w]) {
                dp[h][w] += routeCheck(h + 1, w);
            }
        }
        return dp[h][w];
    }
}

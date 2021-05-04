package com.ozragwort.code.baekjoon;

import java.io.*;
import java.util.*;

public class q11049 {

    int[][] matrix;
    int[][] dp;

    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer stk;
        int N = Integer.parseInt(br.readLine());
        matrix = new int[N][2];
        dp = new int[N][N];

        for (int i = 0 ; i < N ; i++) {
            stk = new StringTokenizer(br.readLine());
            matrix[i][0] = Integer.parseInt(stk.nextToken());
            matrix[i][1] = Integer.parseInt(stk.nextToken());
        }

        if (N == 1) {
            dp[0][0] = 0;
        } else if (N == 2) {
            dp[0][1] = matrix[0][0] * matrix[0][1] * matrix[1][1];
        } else {
            dp[0][1] = matrix[0][0] * matrix[0][1] * matrix[1][1];
            dp[1][2] = matrix[1][0] * matrix[1][1] * matrix[2][1];
            for (int i = 2 ; i < N ; i++) {
                getMinValue(0, i);
            }
        }

        int minValue = dp[0][N - 1];
        bw.write(Integer.toString(minValue));

        bw.flush();
        bw.close();
        br.close();
    }

    public void getMinValue(int start, int end) {
        for (int j = start ; j < end ; j++) {
            if ((dp[j + 1][end] == 0) && (j + 1 != end)) {
                getMinValue(j + 1, end);
            }
            if (dp[start][end] == 0) {
                dp[start][end] = dp[start][j] + dp[j + 1][end] + (matrix[start][0] * matrix[j][1] * matrix[end][1]);
            } else {
                dp[start][end] = Math.min(dp[start][end], dp[start][j] + dp[j + 1][end] + (matrix[start][0] * matrix[j][1] * matrix[end][1]));
            }
        }
    }
}

package com.ozragwort.code.baekjoon;

import java.io.*;
import java.util.StringTokenizer;

public class q1010 {

    int[][] dp = new int[30][30];

    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int T = Integer.parseInt(br.readLine());

        for (int i = 0 ; i < T ; i++) {
            StringTokenizer stk = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(stk.nextToken());
            int M = Integer.parseInt(stk.nextToken());
            bw.write(combination(M, N) + "\n");
        }

        bw.flush();
        bw.close();
        br.close();
    }

    public int combination(int m, int n) {
        if (m == n) {
            return 1;
        } else if (n == 1 || n == m - 1) {
            dp[m][n] = m;
            return dp[m][n];
        } else if (dp[m][n] != 0) {
            return dp[m][n];
        } else {
            dp[m][n] = combination(m - 1, n) + combination(m - 1, n - 1);
            return dp[m][n];
        }
    }
}

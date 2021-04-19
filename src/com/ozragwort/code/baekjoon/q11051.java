package com.ozragwort.code.baekjoon;

import java.io.*;
import java.util.StringTokenizer;

public class q11051 {

    int[][] dp = new int[1001][1001];

    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer stk = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(stk.nextToken());
        int K = Integer.parseInt(stk.nextToken());
        int result = bc(N, Math.min(K, N - K));

        bw.write(Integer.toString(result));

        bw.flush();
        bw.close();
        br.close();
    }

    public int bc(int n, int k) {
        if (k == 0 || k == n) {
            return 1;
        } else if (k == 1 || k == n - 1) {
            dp[n][k] = n;
            return dp[n][k];
        } else if (dp[n][k] != 0) {
            return dp[n][k];
        } else {
            dp[n][k] = (bc(n - 1, k) + bc(n - 1, k - 1)) % 10007;
            return dp[n][k];
        }
    }
}

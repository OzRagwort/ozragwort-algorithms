package com.ozragwort.code.baekjoon;

import java.io.*;
import java.util.StringTokenizer;

public class q9084 {
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int T = Integer.parseInt(br.readLine());
        StringTokenizer stk;

        for (int t = 0 ; t < T ; t++) {
            int N = Integer.parseInt(br.readLine());
            int[] coin = new int[N];
            stk = new StringTokenizer(br.readLine());
            for (int i = 0 ; i < N ; i++) {
                coin[i] = Integer.parseInt(stk.nextToken());
            }
            int M = Integer.parseInt(br.readLine());
            int[] dp = new int[M + 1];
            dp[0] = 1;

            for (int i = 0 ; i < N ; i++) {

                for (int j = 0 ; j <= M ; j++) {
                    if ((dp[j] != 0 || j == 0) && j + coin[i] <= M) {
                        dp[j + coin[i]] += dp[j];
                    }
                }
            }

            bw.write(dp[M] + "\n");
        }

        bw.flush();
        bw.close();
        br.close();
    }
}

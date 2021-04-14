package com.ozragwort.code.baekjoon;

import java.io.*;
import java.util.*;

public class q12865 {
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer stk = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(stk.nextToken());
        int K = Integer.parseInt(stk.nextToken());
        int[][] arr = new int[N][2];
        int[] dp = new int[K];
        int max = Integer.MIN_VALUE;

        for (int i = 0 ; i < N ; i++) {
            stk = new StringTokenizer(br.readLine());
            arr[i][0] = Integer.parseInt(stk.nextToken());
            arr[i][1] = Integer.parseInt(stk.nextToken());
        }

        for (int i = 0 ; i < N ; i++) {
            for (int j = K ; j > 0 ; j--) {
                if (dp[j - 1] != 0) {
                    if (j + arr[i][0] <= K) {
                        dp[j + arr[i][0] - 1] = Math.max(dp[j + arr[i][0] - 1], dp[j - 1] + arr[i][1]);
                    }
                }
            }
            if (arr[i][0] <= K) {
                dp[arr[i][0] - 1] = Math.max(dp[arr[i][0] - 1], arr[i][1]);
            }
        }

        for (int i = 0 ; i < K ; i++) {
            if (max < dp[i]) {
                max = dp[i];
            }
        }

        bw.write(Integer.toString(max));

        bw.flush();
        bw.close();
        br.close();
    }
}

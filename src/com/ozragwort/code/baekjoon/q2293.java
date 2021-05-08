package com.ozragwort.code.baekjoon;

import java.io.*;
import java.util.*;

public class q2293 {
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer stk = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(stk.nextToken());
        int k = Integer.parseInt(stk.nextToken());
        int[] coin = new int[n];
        int[] dp = new int[k];

        for (int i = 0 ; i < n ; i++) {
            coin[i] = Integer.parseInt(br.readLine());
            // 동전 가치가 k 보다 클 경우 아래 계산에서 무시하도록 n을 1 줄여줌
            if (coin[i] > k) {
                n--;
                i--;
            }
        }

        for (int i = 0 ; i < n ; i++) {
            dp[coin[i] - 1]++;
            for (int j = 0 ; j < k ; j++) {
                if (j - coin[i] >= 0) {
                    dp[j] += dp[j - coin[i]];
                }
            }
        }

        bw.write(Integer.toString(dp[k - 1]));

        bw.flush();
        bw.close();
        br.close();
    }
}

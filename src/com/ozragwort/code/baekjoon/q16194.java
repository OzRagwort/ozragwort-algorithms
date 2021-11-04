package com.ozragwort.code.baekjoon;

import java.io.*;
import java.util.*;

public class q16194 {

    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        StringTokenizer stk = new StringTokenizer(br.readLine());
        int[] dp = new int[N + 1];
        int[] cards = new int[N + 1];

        for (int i = 1 ; i <= N ; i++) {
            dp[i] = Integer.MAX_VALUE;
            cards[i] = Integer.parseInt(stk.nextToken());
        }

        for (int i = 1 ; i <= N ; i++) {
            for (int j = 1 ; j <= i ; j++) {
                dp[i] = Math.min(dp[i], dp[i - j] + cards[j]);
            }
        }

        System.out.println(dp[N]);

        br.close();
    }

}

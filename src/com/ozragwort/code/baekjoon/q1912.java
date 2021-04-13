package com.ozragwort.code.baekjoon;

import java.io.*;
import java.util.*;

public class q1912 {
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer stk;
        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];
        int max = Integer.MIN_VALUE;
        int[] dp = new int[N];

        stk = new StringTokenizer(br.readLine());
        for (int i = 0 ; i < N ; i++) {
            arr[i] = Integer.parseInt(stk.nextToken());
        }

        dp[0] = arr[0];
        max = dp[0];
        for (int i = 1 ; i < N ; i++) {
            dp[i] = Math.max(dp[i-1] + arr[i], arr[i]);
            max = Math.max(max, dp[i]);
        }

        bw.write(Integer.toString(max));

        bw.flush();
        bw.close();
        br.close();
    }
}

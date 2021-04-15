package com.ozragwort.code.baekjoon;

import java.io.*;
import java.util.*;

public class q11399 {
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer stk;
        int N = Integer.parseInt(br.readLine());
        int[] P = new int[N];
        int[] dp = new int[N];
        int min = 0;

        stk = new StringTokenizer(br.readLine());
        for (int i = 0 ; i < N ; i++) {
            P[i] = Integer.parseInt(stk.nextToken());
        }

        Arrays.sort(P);

        dp[0] = P[0];
        min = dp[0];
        for (int i = 1 ; i < N ; i++) {
            dp[i] = P[i] + dp[i - 1];
            min += dp[i];
        }

        bw.write(Integer.toString(min));

        bw.flush();
        bw.close();
        br.close();
    }
}

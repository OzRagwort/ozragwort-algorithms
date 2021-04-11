package com.ozragwort.code.baekjoon;

import java.io.*;
import java.util.*;

public class q11053 {
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer stk;
        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];
        int[] dp = new int[N];
        stk = new StringTokenizer(br.readLine());
        int max = Integer.MIN_VALUE;

        for (int i = 0 ; i < N ; i++) {
            arr[i] = Integer.parseInt(stk.nextToken());
        }

        for (int i = 0 ; i < N ; i++) {
            dp[i] = 1;
            for (int j = 0 ; j < i ; j++) {
                if (arr[j] < arr[i]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
            if (max < dp[i])
                max = dp[i];
        }

        bw.write(Integer.toString(max));

        bw.flush();
        bw.close();
        br.close();
    }

}

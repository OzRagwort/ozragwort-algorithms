package com.ozragwort.code.baekjoon;

import java.io.*;
import java.util.*;

public class q2629 {
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer stk;
        int N, M;
        int[] weight, marble;
        boolean[] dp = new boolean[40000];
        HashSet<Integer> set = new HashSet<>();

        N = Integer.parseInt(br.readLine());
        weight = new int[N];
        stk = new StringTokenizer(br.readLine());
        for (int i = 0 ; i < N ; i++) {
            weight[i] = Integer.parseInt(stk.nextToken());

            HashSet<Integer> tset = new HashSet<>();
            for (int n : set) {
                tset.add(n + weight[i]);
                if (n - weight[i] > 0) {
                    tset.add(n - weight[i]);
                }
                if (weight[i] - n > 0) {
                    tset.add(weight[i] - n);
                }
            }

            set.add(weight[i]);
            set.addAll(tset);
        }

        for (int n : set) {
            dp[n - 1] = true;
        }

        M = Integer.parseInt(br.readLine());
        marble = new int[M];
        stk = new StringTokenizer(br.readLine());
        for (int i = 0 ; i < M ; i++) {
            marble[i] = Integer.parseInt(stk.nextToken());
            if (dp[marble[i] - 1]) {
                bw.write("Y ");
            } else {
                bw.write("N ");
            }
        }

        bw.flush();
        bw.close();
        br.close();
    }
}

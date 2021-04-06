package com.ozragwort.code.baekjoon;

import java.io.*;
import java.util.*;

public class q1149 {

    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer stk;
        int[][] cost;
        int N;
        int min;
        N = Integer.parseInt(br.readLine());
        cost = new int[N][3];

        for (int i = 0; i < N ; i++) {
            stk = new StringTokenizer(br.readLine());
            cost[i][0] = Integer.parseInt(stk.nextToken());
            cost[i][1] = Integer.parseInt(stk.nextToken());
            cost[i][2] = Integer.parseInt(stk.nextToken());
        }

        min = func(cost, 1, N);
        bw.write(Integer.toString(min));

        bw.flush();
        bw.close();
        br.close();
    }

    public int func(int[][] cost, int home, int N) {
        cost[home][0] += Math.min(cost[home - 1][1], cost[home - 1][2]);
        cost[home][1] += Math.min(cost[home - 1][0], cost[home - 1][2]);
        cost[home][2] += Math.min(cost[home - 1][0], cost[home - 1][1]);
        if (home == N - 1) {
            return Math.min(cost[N - 1][0], Math.min(cost[N - 1][1], cost[N - 1][2]));
        } else {
            return func(cost, home + 1, N);
        }
    }

}

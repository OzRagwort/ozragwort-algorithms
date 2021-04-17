package com.ozragwort.code.baekjoon;

import java.io.*;
import java.util.*;

public class q13305 {
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer stk;
        int N = Integer.parseInt(br.readLine());
        int[] dist = new int[N - 1];
        int[] oilCost = new int[N];
        long nowCost;
        long sumCost = 0;

        stk = new StringTokenizer(br.readLine());
        for (int i = 0 ; i < dist.length ; i++) {
            dist[i] = Integer.parseInt(stk.nextToken());
        }

        stk = new StringTokenizer(br.readLine());
        for (int i = 0 ; i < oilCost.length ; i++) {
            oilCost[i] = Integer.parseInt(stk.nextToken());
        }

        nowCost = oilCost[0];
        for (int i = 1 ; i < N ; i++) {
            sumCost += dist[i - 1] * nowCost;
            if (nowCost > oilCost[i]) {
                nowCost = oilCost[i];
            }
        }

        bw.write(Long.toString(sumCost));

        bw.flush();
        bw.close();
        br.close();
    }
}

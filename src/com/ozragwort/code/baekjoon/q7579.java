package com.ozragwort.code.baekjoon;

import java.io.*;
import java.util.*;

public class q7579 {
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer stk = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(stk.nextToken());
        int M = Integer.parseInt(stk.nextToken());
        int[][] appData = new int[N][2];
        int[] dp = new int[10000];
        int minValue = Integer.MAX_VALUE;

        StringTokenizer stkByte = new StringTokenizer(br.readLine());
        StringTokenizer stkCost = new StringTokenizer(br.readLine());
        for (int i = 0 ; i < N ; i++) {
            appData[i][0] = Integer.parseInt(stkByte.nextToken());
            appData[i][1] = Integer.parseInt(stkCost.nextToken());
        }

        for (int i = 0 ; i < N ; i++) {
            for (int j = 9999 ; j >= 0 ; j--) {
                if (dp[j] != 0) {
                    dp[j + appData[i][1]] = Math.max(dp[j + appData[i][1]], dp[j] + appData[i][0]);
                }
            }
            if (dp[appData[i][1]] < appData[i][0]) {
                dp[appData[i][1]] = appData[i][0];
            }
        }

        for (int i = 0 ; i < 10000 ; i++) {
            if (dp[i] >= M) {
                minValue = i;
                break;
            }
        }

        bw.write(Integer.toString(minValue));

        bw.flush();
        bw.close();
        br.close();
    }
}

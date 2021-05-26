package com.ozragwort.code.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class q1535 {
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stkH, stkG;
        int N = Integer.parseInt(br.readLine());
        int[][] hg = new int[N][2];
        int[] dp = new int[100];
        int maxHappy = 0;

        stkH = new StringTokenizer(br.readLine());
        stkG = new StringTokenizer(br.readLine());
        for (int i = 0 ; i < N ; i++) {
            hg[i][0] = Integer.parseInt(stkH.nextToken());
            hg[i][1] = Integer.parseInt(stkG.nextToken());
        }

        for (int i = 0 ; i < N ; i++) {
            for (int j = 99 ; j >= 0 ; j--) {
                if (dp[j] != 0 && (j + hg[i][0]) < 100) {
                    dp[j + hg[i][0]] = Math.max(dp[j + hg[i][0]], dp[j] + hg[i][1]);
                }
            }
            if (hg[i][0] < 100) {
                dp[hg[i][0]] = Math.max(dp[hg[i][0]], hg[i][1]);
            }
        }

        for (int i = 0 ; i < 100 ; i++) {
            if (maxHappy < dp[i]) {
                maxHappy = dp[i];
            }
        }

        System.out.print(maxHappy);
    }
}

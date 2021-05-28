package com.ozragwort.code.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class q19622 {
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[][] table = new int[N + 1][3];
        int[] dp = new int[N + 1];

        for (int i = 1 ; i <= N ; i++) {
            StringTokenizer stk = new StringTokenizer(br.readLine());
            table[i][0] = Integer.parseInt(stk.nextToken());
            table[i][1] = Integer.parseInt(stk.nextToken());
            table[i][2] = Integer.parseInt(stk.nextToken());
        }

        Arrays.sort(table, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if (o1[1] == o2[1]) {
                    return o1[0] - o2[0];
                } else {
                    return o1[1] - o2[1];
                }
            }
        });

        int max = 0;
        for (int i = 1 ; i <= N ; i++) {
            for (int j = i - 1 ; j >= 0 ; j--) {
                if (table[i][0] >= table[j][1]) {
                    dp[i] = Math.max(max, dp[j] + table[i][2]);
                    break;
                }
            }
            if (max < dp[i]) {
                max = dp[i];
            }
        }

        System.out.print(max);
    }
}

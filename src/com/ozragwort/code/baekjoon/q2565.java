package com.ozragwort.code.baekjoon;

import java.io.*;
import java.util.*;

public class q2565 {
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer stk;
        int N = Integer.parseInt(br.readLine());
        int[][] lines = new int[N][2];
        int[] dp = new int[N];
        int max = Integer.MIN_VALUE;

        for (int i = 0 ; i < N ; i++) {
            stk = new StringTokenizer(br.readLine());
            lines[i][0] = Integer.parseInt(stk.nextToken());
            lines[i][1] = Integer.parseInt(stk.nextToken());
        }

        Arrays.sort(lines, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] - o2[0];
            }
        });

        for (int i = 0 ; i < N ; i++) {
            dp[i] = 1;
            for (int j = 0 ; j < i ; j++) {
                if (lines[i][1] > lines[j][1]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
            if (max < dp[i])
                max = dp[i];
        }

        bw.write(Integer.toString(N - max));

        bw.flush();
        bw.close();
        br.close();
    }
}

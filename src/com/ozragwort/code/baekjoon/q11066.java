package com.ozragwort.code.baekjoon;

import java.io.*;
import java.util.*;

public class q11066 {

    int[][] dp;

    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer stk;
        int T = Integer.parseInt(br.readLine());

        while (T-- > 0) {
            int K = Integer.parseInt(br.readLine());
            stk = new StringTokenizer(br.readLine());
            int[] page = new int[K];
            dp = new int[page.length][page.length];

            for (int i = 0 ; i < K ; i++) {
                page[i] = Integer.parseInt(stk.nextToken());
            }

            getMinSize(page);

            bw.write(dp[0][K - 1] + "\n");
        }

        bw.flush();
        bw.close();
        br.close();
    }

    public void getMinSize(int[] page) {
        int[] sum = sum(page);

        dp[0][1] = page[0] + page[1];
        dp[1][2] = page[1] + page[2];

        for (int i = 2 ; i < page.length ; i++) {
            minSize(sum, 0, i);
        }
    }

    public void minSize(int[] sum, int start, int end) {

        for (int i = start ; i < end ; i++) {
            if (dp[start + 1][end] == 0 && (start + 1 != end)) {
                minSize(sum, start + 1, end);
            }
            if (start == 0) {
                if (dp[start][end] == 0) {
                    dp[start][end] = dp[start][i] + dp[start + 1][end] + sum[end];
                } else {
                    dp[start][end] = Math.min(dp[start][end], dp[start][i] + dp[i + 1][end] + sum[end]);
                }
            } else {
                if (dp[start][end] == 0) {
                    dp[start][end] = dp[start][i] + dp[start + 1][end] + sum[end] - sum[start - 1];
                } else {
                    dp[start][end] = Math.min(dp[start][end], dp[start][i] + dp[i + 1][end] + sum[end] - sum[start - 1]);
                }
            }
        }

    }

    public int[] sum(int[] page) {
        int[] sum = new int[page.length];

        sum[0] = page[0];
        for (int i = 1 ; i < page.length ; i++) {
            sum[i] = sum[i - 1] + page[i];
        }

        return sum;
    }
}

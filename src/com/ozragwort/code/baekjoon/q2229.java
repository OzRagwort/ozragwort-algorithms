package com.ozragwort.code.baekjoon;

import java.io.*;
import java.util.*;

public class q2229 {

    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        StringTokenizer stk = new StringTokenizer(br.readLine());

        int[] people = new int[N];
        for (int i = 0 ; i < N ; i++) {
            people[i] = Integer.parseInt(stk.nextToken());
        }

        int[][][] scores = new int[N][N][2];
        for (int e = 0 ; e < N ; e++) {
            for (int s = e ; s >= 0 ; s--) {
                if (s == e) {
                    scores[s][e][0] = people[s];
                    scores[s][e][1] = people[s];
                } else {
                    scores[s][e][0] = Math.min(scores[s + 1][e][0], people[s]);
                    scores[s][e][1] = Math.max(scores[s + 1][e][1], people[s]);
                }
            }
        }

        int[] dp = new int[N];

        dp[0] = 0;
        dp[1] = scores[0][1][1] - scores[0][1][0];
        for (int i = 2 ; i < N ; i++) {
            dp[i] = scores[0][i][1] - scores[0][i][0];
            for (int j = 1 ; j <= i ; j++) {
                dp[i] = Math.max(dp[i], dp[j - 1] + scores[j][i][1] - scores[j][i][0]);
            }
        }

        System.out.println(dp[N - 1]);

        br.close();
    }

}

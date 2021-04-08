package com.ozragwort.code.baekjoon;

import java.io.*;

public class q2156 {

    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());
        int[] cup = new int[N];
        int[] dp = new int[N];

        for (int i = 0 ; i < N ; i++) {
            cup[i] = Integer.parseInt(br.readLine());
        }

        if (N >= 1) {
            dp[0] = cup[0];
        } if (N >= 2) {
            dp[1] = cup[0] + cup[1];
        } if (N >= 3) {
            dp[2] = Math.max(cup[0] + cup[1], Math.max(cup[0] + cup[2], cup[1] + cup[2]));
        } if (N >= 4) {
            dp[3] = Math.max(cup[0] + cup[1] + cup[3], Math.max(cup[0] + cup[2] + cup[3], cup[1] + cup[2]));
        } if (N >= 5) {
            for (int i = 4 ; i < N ; i++) {
                dp[i] = Math.max(
                        Math.max(dp[i - 1], dp[i - 2] + cup[i]),
                        Math.max(dp[i - 3] + cup[i - 1] + cup[i], dp[i - 4] + cup[i - 2] + cup[i - 1])
                );
            }
        }

        bw.write(Integer.toString(dp[N - 1]));

        bw.flush();
        bw.close();
        br.close();
    }

}

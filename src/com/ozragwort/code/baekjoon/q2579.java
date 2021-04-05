package com.ozragwort.code.baekjoon;

import java.io.*;

public class q2579 {

    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());
        int[] score = new int[N];
        int[] dpScore = new int[N];

        for (int i = 0 ; i < N ; i++) {
            score[i] = Integer.parseInt(br.readLine());
        }

        if (N == 1) {
            dpScore[0] = score[0];
        } else if (N == 2) {
            dpScore[0] = score[0];
            dpScore[1] = score[0] + score[1];
        } else if (N == 3) {
            dpScore[0] = score[0];
            dpScore[1] = score[0] + score[1];
            dpScore[2] = Math.max(score[0] + score[2], score[1] + score[2]);
        } else {
            dpScore[0] = score[0];
            dpScore[1] = score[0] + score[1];
            dpScore[2] = Math.max(score[0] + score[2], score[1] + score[2]);
            for (int i = 3 ; i < N ; i++) {
                dpScore[i] = Math.max(dpScore[i - 3] + score[i - 1] + score[i], dpScore[i - 2] + score[i]);
            }
        }

        bw.write(Integer.toString(dpScore[N-1]));

        bw.flush();
        bw.close();
        br.close();
    }

}

package com.ozragwort.code.baekjoon;

import java.io.*;
import java.util.*;

public class q1546 {

    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        StringTokenizer stk = new StringTokenizer(br.readLine());
        int[] scores = new int[N];
        double max = 0;

        for (int i = 0 ; i < N ; i++) {
            scores[i] = Integer.parseInt(stk.nextToken());
            max = Math.max(max, scores[i]);
        }

        double sum = 0;
        for (int i = 0 ; i < N ; i++) {
            sum += ((double) scores[i] / max) * 100;
        }

        System.out.println(sum / N);

        bw.flush();
        bw.close();
        br.close();
    }

}

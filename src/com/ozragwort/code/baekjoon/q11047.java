package com.ozragwort.code.baekjoon;

import java.io.*;
import java.util.*;

public class q11047 {
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer stk = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(stk.nextToken());
        int K = Integer.parseInt(stk.nextToken());
        int[] coin = new int[N];
        int counter = 0;

        for (int i = 0 ; i < N ; i++) {
            coin[i] = Integer.parseInt(br.readLine());
        }

        for (int i = N - 1 ; i >= 0 ; i--) {
            if (K >= coin[i]) {
                counter += K / coin[i];
                K %= coin[i];
            }
        }

        bw.write(Integer.toString(counter));

        bw.flush();
        bw.close();
        br.close();
    }
}

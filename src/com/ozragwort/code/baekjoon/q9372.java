package com.ozragwort.code.baekjoon;

import java.io.*;
import java.util.StringTokenizer;

public class q9372 {
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer stk;
        int T = Integer.parseInt(br.readLine());

        for (int i = 0 ; i < T ; i++) {
            stk = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(stk.nextToken());
            int M = Integer.parseInt(stk.nextToken());
            for (int j = 0 ; j < M ; j++) {
                br.readLine();
            }
            bw.write(N - 1 + "\n");
        }

        bw.flush();
        bw.close();
        br.close();
    }
}

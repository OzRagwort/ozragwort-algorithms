package com.ozragwort.code.baekjoon;

import java.io.*;
import java.util.StringTokenizer;

public class q11050 {
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer stk = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(stk.nextToken());
        int K = Integer.parseInt(stk.nextToken());
        int result = factorial(N) / (factorial(K) * factorial(N - K));

        bw.write(Integer.toString(result));

        bw.flush();
        bw.close();
        br.close();
    }

    public int factorial(int i) {
        if (i <= 1) {
            return 1;
        } else {
            return i * factorial(i - 1);
        }
    }
}

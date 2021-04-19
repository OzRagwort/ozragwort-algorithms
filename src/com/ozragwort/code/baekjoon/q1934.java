package com.ozragwort.code.baekjoon;

import java.io.*;
import java.util.StringTokenizer;

public class q1934 {
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer stk;
        int N = Integer.parseInt(br.readLine());

        for (int i = 0 ; i < N ; i++) {
            stk = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(stk.nextToken());
            int b = Integer.parseInt(stk.nextToken());
            int gcd = gcd(Math.max(a, b), Math.min(a, b));
            bw.write((a * b / gcd) + "\n");
        }

        bw.flush();
        bw.close();
        br.close();
    }

    public int gcd(int a, int b) {
        if (a % b == 0) {
            return b;
        } else {
            return gcd(b, a % b);
        }
    }
}

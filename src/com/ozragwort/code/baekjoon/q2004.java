package com.ozragwort.code.baekjoon;

import java.io.*;
import java.util.*;

public class q2004 {

    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer stk = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(stk.nextToken());
        int m = Integer.parseInt(stk.nextToken());

        int counter2 = counting(n, 2) - counting(m, 2) - counting(n - m, 2);
        int counter5 = counting(n, 5) - counting(m, 5) - counting(n - m, 5);

        System.out.println(Math.min(counter2, counter5));

        bw.flush();
        bw.close();
        br.close();
    }

    public int counting(int num, int p) {
        int counter = 0;
        long buf = p;

        while (buf <= num) {
            counter += num / buf;
            buf *= p;
        }

        return counter;
    }

}

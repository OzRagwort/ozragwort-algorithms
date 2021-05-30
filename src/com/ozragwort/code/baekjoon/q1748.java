package com.ozragwort.code.baekjoon;

import java.io.*;

public class q1748 {
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        long length = 0;

        for (long i = 1 ; i <= 9 ; i++) {
            if (N >= Math.pow(10, i)) {
                length += 9 * Math.pow(10, i - 1) * i;
            } else {
                length += (N - Math.pow(10, i - 1) + 1) * i;
                break;
            }
        }

        System.out.print(length);
    }
}

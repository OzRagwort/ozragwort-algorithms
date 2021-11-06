package com.ozragwort.code.baekjoon;

import java.io.*;

public class q1789 {

    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        long S = Long.parseLong(br.readLine());
        long N = 0;

        for (long i = 1 ; i < Integer.MAX_VALUE ; i++) {
            long sum = (i * (i + 1)) / 2;

            if (sum <= S) {
                N = i;
            } else {
                break;
            }
        }

        System.out.println(N);

        br.close();
    }

}

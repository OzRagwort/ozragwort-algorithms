package com.ozragwort.code.baekjoon;

import java.io.*;

public class q1475 {

    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        int[] count = new int[9];

        while (N > 0) {
            int n = N % 10;
            N /= 10;
            if (n == 9) {
                count[6]++;
            } else {
                count[n]++;
            }
        }

        int min = 0;
        for (int i = 0 ; i < 9 ; i++) {
            if (i == 6) {
                int ceil = count[i] / 2 + count[i] % 2;
                min = Math.max(min, ceil);
            } else {
                min = Math.max(min, count[i]);
            }
        }
        System.out.println(min);

        bw.flush();
        bw.close();
        br.close();
    }

}

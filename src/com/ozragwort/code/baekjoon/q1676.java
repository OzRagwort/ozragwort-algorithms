package com.ozragwort.code.baekjoon;

import java.io.*;

public class q1676 {
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());
        int check2 = 0;
        int check5 = 0;

        if (N == 0) {
            bw.write(Integer.toString(0));
        } else {
            for (int i = 1 ; i <= N ; i++) {
                check2 += modCheck(i, 2);
                check5 += modCheck(i, 5);
            }
            bw.write(Integer.toString(Math.min(check2, check5)));
        }

        bw.flush();
        bw.close();
        br.close();
    }

    public int modCheck(int i, int n) {
        int counter = 0;
        while (i % n == 0) {
            i /= n;
            counter++;
        }
        return counter;
    }
}

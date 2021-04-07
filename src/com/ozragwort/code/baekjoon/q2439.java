package com.ozragwort.code.baekjoon;

import java.io.*;

public class q2439 {
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());

        for (int i = 0 ; i < N ; i++) {
            for (int j = N - i - 1 ; j > 0 ; j--) {
                bw.write(" ");
            }
            for (int j = i ; j >= 0 ; j--) {
                bw.write("*");
            }
            bw.newLine();
        }

        bw.flush();
        bw.close();
        br.close();
    }
}

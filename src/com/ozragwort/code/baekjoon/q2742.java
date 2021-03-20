package com.ozragwort.code.baekjoon;

import java.io.*;

public class q2742 {
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());

        while(N > 0) {
            bw.write(N + "\n");
            N--;
        }

        bw.flush();
        bw.close();
        br.close();
    }
}

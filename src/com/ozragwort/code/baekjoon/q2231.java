package com.ozragwort.code.baekjoon;

import java.io.*;

public class q2231 {
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());
        int C = 0;

        for (int i = N ; i >= 1 ; i--) {
            int buf = i;
            int s = i;
            while(buf > 0) {
                s += buf % 10;
                buf /= 10;
            }
            if (s == N) {
                C = i;
            }
        }

        bw.write(Integer.toString(C));
        bw.flush();
        bw.close();
        br.close();
    }
}

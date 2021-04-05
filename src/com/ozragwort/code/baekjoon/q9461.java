package com.ozragwort.code.baekjoon;

import java.io.*;

public class q9461 {

    long[] counter = new long[100];

    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        counter[0] = 1;
        counter[1] = 1;
        counter[2] = 1;
        counter[3] = 2;
        counter[4] = 2;
        int T = Integer.parseInt(br.readLine());

        for (int i = 0 ; i < T ; i++) {
            int N = Integer.parseInt(br.readLine());
            bw.write(func(N) + "\n");
        }

        bw.flush();
        bw.close();
        br.close();
    }

    public long func(int N) {
        if (counter[N - 1] == 0) {
            counter[N - 1] = func(N - 1) + func(N - 5);
        }
        return counter[N - 1];
    }

}

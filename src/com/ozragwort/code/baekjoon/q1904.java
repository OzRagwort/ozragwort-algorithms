package com.ozragwort.code.baekjoon;

import java.io.*;

public class q1904 {

    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int[] counter = new int[1000000];
        counter[0] = 1;
        counter[1] = 2;
        int N = Integer.parseInt(br.readLine());

        for (int i = 2 ; i < N ; i++) {
            counter[i] = (counter[i - 1] + counter[i - 2]) % 15746;
        }

        bw.write(Integer.toString(counter[N - 1]));

        bw.flush();
        bw.close();
        br.close();
    }

}

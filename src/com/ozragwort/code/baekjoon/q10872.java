package com.ozragwort.code.baekjoon;

import java.io.*;

public class q10872 {
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        bw.write(Integer.toString(func(N)));

        bw.flush();
        bw.close();
        br.close();
    }

    public int func(int n) {
        if (n == 1 || n == 0) {
            return 1;
        }
        return n * func(n - 1);
    }
}

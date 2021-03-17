package com.ozragwort.code.baekjoon;

import java.io.*;

public class q10870 {
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
//        N-1때문에 stackOverFlow가 발생 (이런거 조심해야함)
//        bw.write(Integer.toString(func(N-1, 0, 1)));
        bw.write(Integer.toString(func(N, 0, 1)));

        bw.flush();
        bw.close();
        br.close();
    }

    public int func(int n, int a, int b) {
        if (n == 0) {
            return a;
        }
        return func(n - 1, b, a + b);
    }
}

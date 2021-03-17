package com.ozragwort.code.baekjoon;

import java.io.*;

public class q11729 {

    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int counter = (int) Math.pow(2, N) - 1;
        bw.write(Integer.toString(counter));
        bw.newLine();

        func(N, 1, 2, 3);

        bw.flush();
        bw.close();
        br.close();
    }

    public void func(int n, int start, int buffer, int target) throws IOException {
        if (n == 1) {
            bw.write(start + " " + target);
            bw.newLine();
        } else {
            func(n - 1, start, target, buffer);
            bw.write(start + " " + target);
            bw.newLine();
            func(n - 1, buffer, start, target);
        }
    }
}

/*
N이 홀수인 경우 -> 홀수의 target = 3, 짝수 = buffer
 */

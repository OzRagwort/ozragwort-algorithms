package com.ozragwort.code.baekjoon;

import java.io.*;

public class q2723 {
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        long[][] counter = new long[12][12];
        long[] result = new long[12];

        counter[1][1] = result[1] = 1;
        for (int i = 2 ; i <= 11 ; i++) {
            counter[i][1] = counter[i - 1][1] * 2 + 1;
            result[i] += counter[i][1];

            for (int j = 2 ; j < i; j++) {
                counter[i][j] = (counter[i - 1][j - 1] + counter[i - 1][j]) * j + counter[i - 1][j];
                result[i] += counter[i][j];
            }

            counter[i][i] = factorial(i);
            result[i] += counter[i][i];
        }

        int N = Integer.parseInt(br.readLine());

        for (int i = 0 ; i < N ; i++) {
            bw.write(result[Integer.parseInt(br.readLine())] + "\n");
        }

        bw.flush();
        bw.close();
        br.close();
    }

    public int factorial(int n) {
        int num = 1;
        for (int i = 2 ; i <= n ; i++) {
            num *= i;
        }
        return num;
    }
}

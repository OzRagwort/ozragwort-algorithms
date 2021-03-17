package com.ozragwort.code.baekjoon;

import java.io.*;

public class q2447 {
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        for (int x = 0 ; x < N ; x++) {
            for (int y = 0 ; y < N ; y++) {
                bw.write(func(N, x, y));
            }
            bw.newLine();
        }

        bw.flush();
        bw.close();
        br.close();
    }

    public String func(int n, int x, int y) {
        n /= 3;
        if ((x % 3 == 1) && (y % 3 == 1)) {
            return " ";
        } else if ((x / n == 1) && (y / n == 1)) {
            return " ";
        } else if (n > 3) {
            x %= n;
            y %= n;
            return func(n, x, y);
        } else {
            return "*";
        }
    }
}

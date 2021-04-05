package com.ozragwort.code.baekjoon;

import java.io.*;

public class q10844 {

    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        long[][] table;
        long result = 0;
        int N = Integer.parseInt(br.readLine());
        table = new long[N][10];

        for (int i = 1 ; i < 10 ; i++) {
            table[0][i] = 1;
        }

        for (int i = 1 ; i < N ; i++) {
            table[i][0] = table[i-1][1];
            for (int j = 1 ; j < 9 ; j++) {
                table[i][j] = (table[i-1][j-1] + table[i-1][j+1]) % 1000000000;
            }
            table[i][9] = table[i-1][8];
        }

        for (int i = 0 ; i < 10 ; i++) {
            result += table[N-1][i];
        }
        result %= 1000000000;
        bw.write(Long.toString(result));

        bw.flush();
        bw.close();
        br.close();
    }

}

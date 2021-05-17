package com.ozragwort.code.baekjoon;

import java.io.*;
import java.math.BigInteger;

public class q1247 {
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        for (int t = 0 ; t < 3 ; t++) {
            int N = Integer.parseInt(br.readLine());
            BigInteger num = BigInteger.ZERO;
            for (int i = 0 ; i < N ; i++) {
                BigInteger n = new BigInteger(br.readLine());
                num = num.add(n);
            }

            int check = num.compareTo(BigInteger.ZERO);
            if (check == 0) {
                bw.write("0\n");
            } else if (check > 0) {
                bw.write("+\n");
            } else {
                bw.write("-\n");
            }
        }


        bw.flush();
        bw.close();
        br.close();
    }
}

package com.ozragwort.code.baekjoon;

import java.io.*;

public class q2609 {
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String[] in = br.readLine().split(" ");
        int a = Integer.parseInt(in[0]);
        int b = Integer.parseInt(in[1]);
        int divisor = 0;

        if (a == b) {
            bw.write(a + "\n" + b);
        } else  {
            if (a > b) {
                int t = a;
                a = b;
                b = t;
            }
            for (int i = a ; i > 0 ; i--) {
                if (a % i == 0) {
                    if (b % i == 0) {
                        divisor = i;
                        break;
                    }
                }
            }
            bw.write(divisor + "\n" + (a * b / divisor));
        }

        bw.flush();
        bw.close();
        br.close();
    }
}

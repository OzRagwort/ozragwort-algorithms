package com.ozragwort.code.baekjoon;

import java.io.*;
import java.util.*;

public class q1024 {

    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer stk = new StringTokenizer(br.readLine());
        long N = Long.parseLong(stk.nextToken());
        long L = Long.parseLong(stk.nextToken());

        long start = -1;
        long repeat = 0;

        for (long i = L ; (i * (i - 1)) / 2 <= N ; i++) {
            if (i % 2 == 0) {
                if ((N / (i / 2.0)) % 2 == 1) {
                    start = ((N / (i / 2) - 1) / 2) - (i / 2) + 1;
                    repeat = i;
                    break;
                }
            } else {
                if (N % i == 0) {
                    start = (N / i) - ((i - 1) / 2);
                    repeat = i;
                    break;
                }
            }
        }

        if (start < 0 || repeat > 100) {
            bw.write("-1");
        } else {
            for (int i = 0 ; i < repeat ; i++) {
                bw.write(start + i + " ");
            }
        }

        bw.flush();
        bw.close();
        br.close();
    }

}

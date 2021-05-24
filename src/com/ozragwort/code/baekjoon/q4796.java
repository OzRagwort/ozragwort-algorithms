package com.ozragwort.code.baekjoon;

import java.io.*;
import java.util.StringTokenizer;

public class q4796 {
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer stk;
        int num = 1;

        while (true) {
            stk = new StringTokenizer(br.readLine());
            int L = Integer.parseInt(stk.nextToken());
            int P = Integer.parseInt(stk.nextToken());
            int V = Integer.parseInt(stk.nextToken());
            int counter = 0;

            if (L == 0 && P == 0 && V == 0) {
                break;
            } else {
                while (V > 0) {
                    if (L <= V) {
                        counter += L;
                    } else {
                        counter += V;
                    }
                    V -= P;
                }
            }

            bw.write("Case " + num + ": " + counter + "\n");
            num++;
        }

        bw.flush();
        bw.close();
        br.close();
    }
}

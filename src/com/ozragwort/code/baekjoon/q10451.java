package com.ozragwort.code.baekjoon;

import java.io.*;
import java.util.StringTokenizer;

public class q10451 {

    int[] table;
    boolean[] visit;
    int counter;

    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer stk;
        int T = Integer.parseInt(br.readLine());

        for (int t = 0 ; t < T ; t++) {
            int N = Integer.parseInt(br.readLine());
            table = new int[N + 1];
            visit = new boolean[N + 1];
            counter = 0;

            stk = new StringTokenizer(br.readLine());
            for (int i = 1 ; i <= N ; i++) {
                table[i] = Integer.parseInt(stk.nextToken());
            }

            for (int i = 1 ; i <= N ; i++) {
                if (visit[i]) {
                    continue;
                } else {
                    check(i);
                    counter++;
                }
            }

            bw.write(counter + "\n");
        }

        bw.flush();
        bw.close();
        br.close();
    }

    public void check(int index) {
        if (visit[index]) {
            return;
        } else {
            visit[index] = true;
            check(table[index]);
        }
    }
}

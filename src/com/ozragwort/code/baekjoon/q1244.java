package com.ozragwort.code.baekjoon;

import java.io.*;
import java.util.*;

public class q1244 {

    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        StringTokenizer stk = new StringTokenizer(br.readLine());
        boolean[] state = new boolean[N + 1];

        for (int i = 1 ; i <= N ; i++) {
            state[i] = stk.nextToken().equals("1");
        }

        int rp = Integer.parseInt(br.readLine());

        for (int r = 0 ; r < rp ; r++) {
            stk = new StringTokenizer(br.readLine());
            boolean man = stk.nextToken().equals("1");
            int n = Integer.parseInt(stk.nextToken());

            if (man) {
                for (int i = n ; i <= N ; i+=n) {
                    state[i] ^= true;
                }
            } else {
                state[n] ^= true;
                int w = 1;
                while ((n - w >= 1 && n + w <= N) && state[n + w] == state[n - w]) {
                    state[n + w] ^= true;
                    state[n - w] ^= true;
                    w++;
                }
            }
        }


        for (int i = 1 ; i <= N ; i++) {
            bw.write(state[i] ? "1 " : "0 ");
            if (i % 20 == 0) {
                bw.newLine();
            }
        }

        bw.flush();
        bw.close();
        br.close();
    }

}

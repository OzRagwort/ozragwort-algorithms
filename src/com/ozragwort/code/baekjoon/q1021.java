package com.ozragwort.code.baekjoon;

import java.io.*;
import java.util.*;

public class q1021 {
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        LinkedList<Integer> d = new LinkedList<>();
        StringTokenizer stk = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(stk.nextToken());
        int M = Integer.parseInt(stk.nextToken());
        int[] target = new int[M];
        int counter = 0;

        stk = new StringTokenizer(br.readLine());
        for (int i = 0 ; i < M ; i++) {
            target[i] = Integer.parseInt(stk.nextToken());
        }

        for (int i = 1 ; i <= N ; i++) {
            d.offer(i);
        }

        for (int i = 0 ; i < M ; i++) {
            int c = 0;

            while (d.peek() != target[i]) {
                d.offer(d.poll());
                c++;
            }

            if (d.size() / 2 < c) {
                c = d.size() - c;
            }

            counter += c;

            d.poll();
        }

        bw.write(Integer.toString(counter));

        bw.flush();
        bw.close();
        br.close();
    }
}

package com.ozragwort.code.baekjoon;

import java.io.*;
import java.util.*;

public class q11286 {
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        PriorityQueue<Integer> pq = new PriorityQueue<>(
                (o1, o2) -> {
                    if (Math.abs(o1) == Math.abs(o2)) {
                        return o1 - o2;
                    } else {
                        return Math.abs(o1) - Math.abs(o2);
                }
                });
        int N = Integer.parseInt(br.readLine());

        for (int i = 0 ; i < N ; i++) {
            String in = br.readLine();
            if (in.equals("0")) {
                if (pq.isEmpty()) {
                    bw.write("0\n");
                } else {
                    bw.write(pq.poll() + "\n");
                }
            } else {
                pq.offer(Integer.parseInt(in));
            }
        }

        bw.flush();
        bw.close();
        br.close();
    }
}

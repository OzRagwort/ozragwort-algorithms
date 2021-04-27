package com.ozragwort.code.baekjoon;

import java.io.*;
import java.util.*;

public class q10866 {
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        Deque<Integer> d = new ArrayDeque<>();
        int N = Integer.parseInt(br.readLine());

        for (int i = 0 ; i < N ; i++) {
            String in = br.readLine();

            if (in.startsWith("push_front")) {
                d.push(Integer.parseInt(in.substring(11)));
            } else if (in.startsWith("push_back")) {
                d.offer(Integer.parseInt(in.substring(10)));
            } else if (in.startsWith("pop_front")) {
                if (d.isEmpty()) {
                    bw.write("-1\n");
                } else {
                    bw.write(d.pollFirst() + "\n");
                }
            } else if (in.startsWith("pop_back")) {
                if (d.isEmpty()) {
                    bw.write("-1\n");
                } else {
                    bw.write(d.pollLast() + "\n");
                }
            } else if (in.startsWith("size")) {
                bw.write(d.size() + "\n");
            } else if (in.startsWith("empty")) {
                if (d.isEmpty()) {
                    bw.write("1\n");
                } else {
                    bw.write("0\n");
                }
            } else if (in.startsWith("front")) {
                if (d.isEmpty()) {
                    bw.write("-1\n");
                } else {
                    bw.write(d.peek() + "\n");
                }
            } else {
                if (d.isEmpty()) {
                    bw.write("-1\n");
                } else {
                    bw.write(d.peekLast() + "\n");
                }
            }
        }

        bw.flush();
        bw.close();
        br.close();
    }
}

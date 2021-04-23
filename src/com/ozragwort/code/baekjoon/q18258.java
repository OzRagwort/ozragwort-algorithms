package com.ozragwort.code.baekjoon;

import java.io.*;
import java.util.*;

public class q18258 {
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        LinkedList<Integer> queue = new LinkedList<>();
        int N = Integer.parseInt(br.readLine());

        for (int i = 0 ; i < N ; i++) {
            String in = br.readLine();

            if (in.startsWith("push")) {
                queue.offer(Integer.parseInt(in.substring(5)));
            } else if (in.startsWith("pop")) {
                if (queue.isEmpty()) {
                    bw.write("-1\n");
                } else {
                    bw.write(queue.poll() + "\n");
                }
            } else if (in.startsWith("size")) {
                bw.write(queue.size() + "\n");
            } else if (in.startsWith("empty")) {
                if (queue.isEmpty()) {
                    bw.write("1\n");
                } else {
                    bw.write("0\n");
                }
            } else if (in.startsWith("front")) {
                if (queue.isEmpty()) {
                    bw.write("-1\n");
                } else {
                    bw.write(queue.peek() + "\n");
                }
            } else {
                if (queue.isEmpty()) {
                    bw.write("-1\n");
                } else {
                    bw.write(queue.peekLast() + "\n");
                }
            }
        }

        bw.flush();
        bw.close();
        br.close();
    }
}

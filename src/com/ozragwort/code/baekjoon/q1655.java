package com.ozragwort.code.baekjoon;

import java.io.*;
import java.util.*;

public class q1655 {
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        PriorityQueue<Integer> leftQueue = new PriorityQueue<>((o1, o2) -> o2 - o1);
        PriorityQueue<Integer> rightQueue = new PriorityQueue<>();
        int N = Integer.parseInt(br.readLine());

        for (int i = 0 ; i < N ; i++) {
            int n = Integer.parseInt(br.readLine());
            if (i % 2 == 0) {
                if (rightQueue.isEmpty()) {
                    leftQueue.offer(n);
                } else {
                    if (rightQueue.peek() < n) {
                        leftQueue.offer(rightQueue.poll());
                        rightQueue.offer(n);
                    } else {
                        leftQueue.offer(n);
                    }
                }
            } else {
                if (leftQueue.isEmpty()) {
                    rightQueue.offer(n);
                } else {
                    if (leftQueue.peek() > n) {
                        rightQueue.offer(leftQueue.poll());
                        leftQueue.offer(n);
                    } else {
                        rightQueue.offer(n);
                    }
                }
            }

            bw.write(leftQueue.peek() + "\n");
        }

        bw.flush();
        bw.close();
        br.close();
    }
}

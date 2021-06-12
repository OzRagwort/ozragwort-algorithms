package com.ozragwort.code.baekjoon;

import java.io.*;
import java.util.*;

public class q1327 {

    Queue<char[]> queue = new LinkedList<>();
    Queue<Integer> countQueue = new LinkedList<>();
    int N, K;
    HashSet<String> set = new HashSet<>();

    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stk = new StringTokenizer(br.readLine());
        N = Integer.parseInt(stk.nextToken());
        K = Integer.parseInt(stk.nextToken());
        char[] seq = new char[N];
        char[] sorted = new char[N];
        int count = -1;

        stk = new StringTokenizer(br.readLine());
        for (int i = 0 ; i < N ; i++) {
            seq[i] = sorted[i] = stk.nextToken().charAt(0);
        }

        Arrays.sort(sorted);

        queue.offer(seq);
        countQueue.offer(0);
        while (!queue.isEmpty() && !countQueue.isEmpty()) {
            char[] n = queue.poll();
            int c = countQueue.poll();
            if (Arrays.equals(n, sorted)) {
                queue.clear();
                count = c;
                break;
            } else {
                bfs(n, c);
            }
        }

        System.out.print(count);
    }

    public void bfs(char[] seq, int count) {
        for (int i = 0 ; i <= N - K ; i++) {
            char[] arr = Arrays.copyOf(seq, seq.length);
            for (int j = 0 ; j < K / 2 ; j++) {
                char t = arr[i + j];
                arr[i + j] = arr[i + K - j - 1];
                arr[i + K - j - 1] = t;
            }
            String s = String.valueOf(arr);
            if (set.contains(s)) {
                continue;
            } else {
                set.add(s);
                queue.offer(arr);
                countQueue.offer(count + 1);
            }
        }
    }
}

package com.ozragwort.code.baekjoon;

import java.io.*;
import java.util.*;

public class q2667 {

    boolean[][] table;
    int counter = 0;

    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());
        table = new boolean[N][N];
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        for (int i = 0 ; i < N ; i++) {
            String in = br.readLine();
            for (int j = 0 ; j < N ; j++) {
                if (in.charAt(j) == '1') {
                    table[i][j] = true;
                }
            }
        }

        for (int i = 0 ; i < N ; i++) {
            for (int j = 0 ; j < N ; j++) {
                if (table[i][j]) {
                    counter = 0;
                    dfs(i, j);
                    pq.offer(counter);
                }
            }
        }

        bw.write(Integer.toString(pq.size()));
        while (!pq.isEmpty()) {
            bw.write("\n" + pq.poll());
        }

        bw.flush();
    }

    public void dfs(int i, int j) {
        if (table[i][j]) {
            counter++;
            table[i][j] = false;
            if (i - 1 >= 0) {
                dfs(i - 1, j);
            }
            if (i + 1 < table.length) {
                dfs(i + 1, j);
            }
            if (j - 1 >= 0) {
                dfs(i, j - 1);
            }
            if (j + 1 < table.length) {
                dfs(i, j + 1);
            }
        }
    }
}

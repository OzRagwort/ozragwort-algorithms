package com.ozragwort.code.baekjoon;

import java.io.*;
import java.util.*;

public class q2178 {

    boolean[][] table;
    int[][] dist;
    Queue<Integer[]> queue = new LinkedList<>();
    int N, M;

    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stk = new StringTokenizer(br.readLine());
        N = Integer.parseInt(stk.nextToken());
        M = Integer.parseInt(stk.nextToken());
        table = new boolean[N][M];
        dist = new int[N][M];
        dist[0][0] = 1;

        for (int i = 0 ; i < N ; i++) {
            String in = br.readLine();
            for (int j = 0 ; j < M ; j++) {
                if (in.charAt(j) == '1') {
                    table[i][j] = true;
                }
            }
        }

        queue.offer(new Integer[]{0, 0});
        table[0][0] = false;
        while (!queue.isEmpty()) {
            Integer[] data = queue.poll();
            if (data[0] == N - 1 && data[1] == M - 1) {
                queue.clear();
                break;
            }
            bfs(data[0], data[1]);
        }

        System.out.print(dist[N - 1][M - 1]);
    }

    public void bfs(int i, int j) {
        if (i - 1 >= 0) {
            if (table[i - 1][j]) {
                queue.offer(new Integer[]{i - 1, j});
                dist[i - 1][j] = dist[i][j] + 1;
                table[i - 1][j] = false;
            }
        }
        if (j - 1 >= 0) {
            if (table[i][j - 1]) {
                queue.offer(new Integer[]{i, j - 1});
                dist[i][j - 1] = dist[i][j] + 1;
                table[i][j - 1] = false;
            }
        }
        if (i + 1 < N) {
            if (table[i + 1][j]) {
                queue.offer(new Integer[]{i + 1, j});
                dist[i + 1][j] = dist[i][j] + 1;
                table[i + 1][j] = false;
            }
        }
        if (j + 1 < M) {
            if (table[i][j + 1]) {
                queue.offer(new Integer[]{i, j + 1});
                dist[i][j + 1] = dist[i][j] + 1;
                table[i][j + 1] = false;
            }
        }
    }
}

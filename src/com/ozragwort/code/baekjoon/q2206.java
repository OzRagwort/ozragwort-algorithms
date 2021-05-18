package com.ozragwort.code.baekjoon;

import java.io.*;
import java.util.*;

public class q2206 {

    Queue<Integer[]> queue = new LinkedList<>();
    boolean[][] table;
    boolean[][] visit;
    int[][] dist;
    int[][] revDist;
    int N, M;

    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stk = new StringTokenizer(br.readLine());
        N = Integer.parseInt(stk.nextToken());
        M = Integer.parseInt(stk.nextToken());
        table = new boolean[N][M];
        visit = new boolean[N][M];
        dist = new int[N][M];
        revDist = new int[N][M];

        for (int i = 0 ; i < N ; i++) {
            String in = br.readLine();
            for (int j = 0 ; j < M ; j++) {
                if (in.charAt(j) == '0') {
                    table[i][j] = true;
                }
            }
        }

        int result = getDist();

        System.out.print(result);
    }

    public int getDist() {
        int result = Integer.MAX_VALUE;

        queue.offer(new Integer[]{0, 0});
        visit[0][0] = true;
        dist[0][0] = 1;
        while (!queue.isEmpty()) {
            Integer[] n = queue.poll();
            if (n[0] == N - 1 && n[1] == M - 1) {
                break;
            }
            bfs(n[0], n[1], false);
        }

        queue.clear();
        visit = new boolean[N][M];

        queue.offer(new Integer[]{N - 1, M - 1});
        visit[N - 1][M - 1] = true;
        revDist[N - 1][M - 1] = 1;
        while (!queue.isEmpty()) {
            Integer[] n = queue.poll();
            if (n[0] == 0 && n[1] == 0) {
                break;
            }
            bfs(n[0], n[1], true);
        }

        for (int i = 0 ; i < N ; i++) {
            for (int j = 0 ; j < M ; j++) {
                if (dist[i][j] != 0 && revDist[i][j] != 0) {
                    result = Math.min(result, dist[i][j] + revDist[i][j] - 1);
                }
            }
        }

        if (result == Integer.MAX_VALUE) {
            return -1;
        } else {
            return result;
        }
    }

    public void bfs(int n, int m, boolean rev) {
        int[] dx = {-1, 1, 0, 0};
        int[] dy = {0, 0, -1, 1};

        for (int i = 0 ; i < 4 ; i++) {
            int x = n + dx[i];
            int y = m + dy[i];
            if (0 <= x && x < N && 0 <= y && y < M && !visit[x][y]) {
                if (rev) {
                    revDist[x][y] = revDist[n][m] + 1;
                } else {
                    dist[x][y] = dist[n][m] + 1;
                }
                if (table[x][y]) {
                    queue.offer(new Integer[]{x, y});
                }
                visit[x][y] = true;
            }
        }
    }
}

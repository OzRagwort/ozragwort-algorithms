package com.ozragwort.code.baekjoon;

import java.io.*;
import java.util.*;

public class q7576 {

    boolean[][] table;
    int[][] day;
    Queue<Integer[]> queue = new LinkedList<>();
    int M, N, x, y, counter = 0, empty = 0;
    int[] dm = {-1, 1, 0, 0};
    int[] dn = {0, 0, -1, 1};

    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stk = new StringTokenizer(br.readLine());
        N = Integer.parseInt(stk.nextToken());
        M = Integer.parseInt(stk.nextToken());
        table = new boolean[M][N];
        day = new int[M][N];

        for (int i = 0 ; i < M ; i++) {
            stk = new StringTokenizer(br.readLine());
            for (int j = 0 ; j < N ; j++) {
                String n = stk.nextToken();
                if (n.equals("1")) {
                    queue.offer(new Integer[]{i, j});
                } else if (n.equals("0")) {
                    table[i][j] = true;
                    empty++;
                }
            }
        }

        while (!queue.isEmpty()) {
            Integer[] data = queue.poll();
            bfs(data[0], data[1]);
        }

        System.out.print(empty == 0 ? counter : -1);
    }

    public void bfs(int m, int n) {
        for (int i = 0 ; i < 4 ; i++) {
            x = m + dm[i];
            y = n + dn[i];
            if (0 <= x && x < M && 0 <= y && y < N && table[x][y]) {
                table[x][y] = false;
                queue.offer(new Integer[]{x, y});
                day[x][y] = day[m][n] + 1;
                counter = Math.max(counter, day[x][y]);
                empty--;
            }
        }
    }
}

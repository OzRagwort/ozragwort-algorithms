package com.ozragwort.code.baekjoon;

import java.io.*;
import java.util.*;

public class q1012 {

    boolean[][] table;

    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int T = Integer.parseInt(br.readLine());
        int counter = 0;

        for (int i = 0 ; i < T ; i++) {
            StringTokenizer stk = new StringTokenizer(br.readLine());
            int M = Integer.parseInt(stk.nextToken());
            int N = Integer.parseInt(stk.nextToken());
            int K = Integer.parseInt(stk.nextToken());
            table = new boolean[M][N];

            for (int j = 0 ; j < K ; j++) {
                stk = new StringTokenizer(br.readLine());
                int x = Integer.parseInt(stk.nextToken());
                int y = Integer.parseInt(stk.nextToken());
                table[x][y] = true;
            }

            counter = 0;
            for (int x = 0 ; x < M ; x++) {
                for (int y = 0 ; y < N ; y++) {
                    if (table[x][y]) {
                        counter++;
                        dfs(x, y);
                    }
                }
            }
            bw.write(counter + "\n");
        }

        bw.flush();
    }

    public void dfs(int i, int j) {
        if (table[i][j]) {
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
            if (j + 1 < table[0].length) {
                dfs(i, j + 1);
            }
        }
    }
}

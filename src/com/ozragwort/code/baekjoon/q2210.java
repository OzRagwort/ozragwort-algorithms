package com.ozragwort.code.baekjoon;

import java.io.*;
import java.util.HashSet;
import java.util.StringTokenizer;

public class q2210 {

    int[][] table = new int[5][5];
    HashSet<Integer> set = new HashSet<Integer>();
    int[] dx = new int[]{1, -1, 0, 0};
    int[] dy = new int[]{0, 0, 1, -1};

    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        for (int i = 0 ; i < 5 ; i++) {
            StringTokenizer stk = new StringTokenizer(br.readLine());
            for (int j = 0 ; j < 5 ; j++) {
                table[i][j] = Integer.parseInt(stk.nextToken());
            }
        }

        for (int i = 0 ; i < 5 ; i++) {
            for (int j = 0 ; j < 5 ; j++) {
                dfs(i, j, table[i][j], 1);
            }
        }

        System.out.print(set.size());
    }

    public void dfs(int X, int Y, int data, int depth) {
        if (depth == 6) {
            set.add(data);
        } else {
            for (int i = 0 ; i < 4 ; i++) {
                int x = X + dx[i];
                int y = Y + dy[i];

                if (0 <= x && x < 5 && 0 <= y && y < 5) {
                    dfs(x, y, (data * 10) + table[x][y], depth + 1);
                }
            }
        }

    }
}

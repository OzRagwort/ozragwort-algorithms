package com.ozragwort.code.baekjoon;

import java.io.*;
import java.util.StringTokenizer;

public class q16173 {

    int N;
    int[][] table;

    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stk;
        N = Integer.parseInt(br.readLine());
        table = new int[N][N];

        for (int i = 0 ; i < N ; i++) {
            stk = new StringTokenizer(br.readLine());
            for (int j = 0 ; j < N ; j++) {
                table[i][j] = Integer.parseInt(stk.nextToken());
            }
        }

        if (dfs(0, 0)) {
            System.out.print("HaruHaru");
        } else {
            System.out.print("Hing");
        }
    }

    public boolean dfs(int a, int b) {
        if (a == N - 1 && b == N - 1) {
            return true;
        } else if (table[a][b] == 0) {
            return false;
        } else {
            boolean check = false;

            int[] dx = new int[]{0, table[a][b]};
            int[] dy = new int[]{table[a][b], 0};

            for (int i = 0 ; i < 2 ; i++) {
                int x = a + dx[i];
                int y = b + dy[i];

                if (x < N && y < N) {
                    check |= dfs(x, y);
                }
            }

            return check;
        }
    }
}

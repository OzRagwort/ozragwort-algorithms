package com.ozragwort.code.baekjoon;

import java.io.*;
import java.util.StringTokenizer;

public class q2468 {

    int[][] table;
    boolean[][] visit;
    int N;
    int[] dm = new int[]{1, -1, 0, 0};
    int[] dn = new int[]{0, 0, 1, -1};

    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stk = new StringTokenizer(br.readLine());
        N = Integer.parseInt(stk.nextToken());
        table = new int[N][N];
        int maxHeight = 0;
        int counter = 0;
        int max = 1;

        for (int i = 0 ; i < N ; i++) {
            stk = new StringTokenizer(br.readLine());
            for (int j = 0 ; j < N ; j++) {
                table[i][j] = Integer.parseInt(stk.nextToken());
                if (maxHeight < table[i][j]) {
                    maxHeight = table[i][j];
                }
            }
        }

        for (int h = 1 ; h < maxHeight ; h++) {
            visit = new boolean[N][N];
            counter = 0;
            for (int m = 0 ; m < N ; m++) {
                for (int n = 0 ; n < N ; n++) {
                    if (!visit[m][n] && table[m][n] > h) {
                        dfs(m, n, h);
                        counter++;
                    }
                }
            }
            if (max < counter) {
                max = counter;
            }
        }

        System.out.print(max);
    }

    public void dfs(int m, int n, int h) {
        visit[m][n] = true;

        for (int i = 0 ; i < 4 ; i++) {
            int tm = m + dm[i];
            int tn = n + dn[i];

            if (0 <= tm && tm < N && 0 <= tn && tn < N) {
                if (!visit[tm][tn] && table[m][n] > h) {
                    dfs(tm, tn, h);
                }
            }

        }
    }
}

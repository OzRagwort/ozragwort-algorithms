package com.ozragwort.code.baekjoon;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class q2583 {

    boolean[][] table;
    int M, N, counter = 0;
    List<Integer> list = new ArrayList<>();
    int[] dm = new int[]{1, -1, 0, 0};
    int[] dn = new int[]{0, 0, 1, -1};

    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer stk = new StringTokenizer(br.readLine());
        M = Integer.parseInt(stk.nextToken());
        N = Integer.parseInt(stk.nextToken());
        int K = Integer.parseInt(stk.nextToken());
        table = new boolean[M][N];

        for (int k = 0 ; k < K ; k++) {
            stk = new StringTokenizer(br.readLine());
            int x1 = Integer.parseInt(stk.nextToken());
            int y1 = Integer.parseInt(stk.nextToken());
            int x2 = Integer.parseInt(stk.nextToken());
            int y2 = Integer.parseInt(stk.nextToken());

            for (int n = x1 ; n < x2 ; n++) {
                for (int m = y1 ; m < y2 ; m++) {
                    table[m][n] = true;
                }
            }
        }

        for (int m = 0 ; m < M ; m++) {
            for (int n = 0 ; n < N ; n++) {
                if (!table[m][n]) {
                    counter = 0;
                    dfs(m, n);
                    list.add(counter);
                }
            }
        }

        int[] result = new int[list.size()];
        for (int i = 0 ; i < list.size() ; i++) {
            result[i] = list.get(i);
        }

        Arrays.sort(result);

        bw.write(result.length + "\n");
        for (int i = 0 ; i < result.length ; i++) {
            bw.write(result[i] + " ");
        }

        bw.flush();
        bw.close();
        br.close();

    }

    public void dfs(int m, int n) {
        table[m][n] = true;
        counter++;

        for (int i = 0 ; i < 4 ; i++) {
            int tm = m + dm[i];
            int tn = n + dn[i];

            if (0 <= tm && tm < M && 0 <= tn && tn < N) {
                if (!table[tm][tn]) {
                    dfs(tm, tn);
                }
            }

        }
    }
}

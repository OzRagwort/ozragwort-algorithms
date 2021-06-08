package com.ozragwort.code.baekjoon;

import java.io.*;
import java.util.StringTokenizer;

public class q2644 {

    boolean[][] table;
    boolean[] visit;

    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stk;
        int n = Integer.parseInt(br.readLine());
        stk = new StringTokenizer(br.readLine());
        int A = Integer.parseInt(stk.nextToken());
        int B = Integer.parseInt(stk.nextToken());
        int m = Integer.parseInt(br.readLine());
        table = new boolean[n + 1][n + 1];
        visit = new boolean[n + 1];

        for (int i = 0 ; i < m ; i++) {
            stk = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(stk.nextToken());
            int b = Integer.parseInt(stk.nextToken());

            table[a][b] = table[b][a] = true;
        }

        System.out.println(dfs(A, B, 1));
    }

    public int dfs(int a, int b, int counter) {
        int result = -1;
        visit[a] = true;

        for (int i = 1 ; i < table[a].length ; i++) {
            if (!visit[i] && table[a][i]) {
                if (i == b) {
                    return counter;
                } else {
                    result = Math.max(result, dfs(i, b, counter + 1));
                }
            }
        }

        return result;
    }
}

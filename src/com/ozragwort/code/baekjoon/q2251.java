package com.ozragwort.code.baekjoon;

import java.io.*;
import java.util.StringTokenizer;

public class q2251 {

    int[] bucketSize;
    boolean[] result;
    boolean[][][] visit = new boolean[201][201][201];

    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        bucketSize = new int[3];
        StringTokenizer stk = new StringTokenizer(br.readLine());
        bucketSize[0] = Integer.parseInt(stk.nextToken());
        bucketSize[1] = Integer.parseInt(stk.nextToken());
        bucketSize[2] = Integer.parseInt(stk.nextToken());
        result = new boolean[bucketSize[2] + 1];

        dfs(0, 0, bucketSize[2]);

        for (int i = 0 ; i <= bucketSize[2] ; i++) {
            if (result[i]) {
                bw.write(i + " ");
            }
        }

        bw.flush();
        bw.close();
        br.close();

    }

    public void dfs(int a, int b, int c) {
        if (visit[a][b][c]) {
            return;
        } else {
            visit[a][b][c] = true;
            if (a == 0) {
                result[c] = true;
            }

            // a to b
            if (a + b > bucketSize[1]) {
                dfs(a + b - bucketSize[1], bucketSize[1], c);
            } else {
                dfs(0, a + b, c);
            }

            // a to c
            if (a + c > bucketSize[2]) {
                dfs(a + c - bucketSize[2], b, bucketSize[2]);
            } else {
                dfs(0, b, a + c);
            }

            // b to a
            if (b + a > bucketSize[0]) {
                dfs(bucketSize[0], a + b - bucketSize[0], c);
            } else {
                dfs(a + b, 0, c);
            }

            // b to c
            if (b + c > bucketSize[2]) {
                dfs(a, b + c - bucketSize[2], bucketSize[2]);
            } else {
                dfs(a, 0, b + c);
            }

            // c to a
            if (c + a > bucketSize[0]) {
                dfs(bucketSize[0], b, a + c - bucketSize[0]);
            } else {
                dfs(a + c, b, 0);
            }

            // c to b
            if (c + b > bucketSize[1]) {
                dfs(a, bucketSize[1], b + c - bucketSize[1]);
            } else {
                dfs(a, b + c, 0);
            }
        }
    }
}

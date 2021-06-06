package com.ozragwort.code.baekjoon;

import java.io.*;
import java.util.StringTokenizer;

public class q2341 {
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int[] level = new int[]{1, 86, 172, 256};
        String[] code = new String[]{"00", "01", "10", "11"};

        StringTokenizer stk = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(stk.nextToken());
        int W = Integer.parseInt(stk.nextToken());
        int[] seq = new int[N + 1];
        int[][][] cost = new int[N + 1][2][4];
        int[] minIndex = new int[N + 1];

        for (int i = 1 ; i <= N ; i++) {
            int n = Integer.parseInt(br.readLine());
            seq[i] = n;
        }

        for (int i = 1 ; i <= N ; i++) {
            for (int j = 0 ; j < 4 ; j++) {
                cost[i][0][j] = Integer.MAX_VALUE;
                for (int k = 0 ; k < 4 ; k++) {
                    int errorDist = Math.abs(level[j] - seq[i]);
                    int length = 3;

                    if (i == 1) {
                        length = 2;
                    } else if (j == k) {
                        length = 1;
                    }

                    if (cost[i][0][j] > errorDist + (W * length) + cost[i - 1][0][k]) {
                        cost[i][0][j] = errorDist + (W * length) + cost[i - 1][0][k];
                        cost[i][1][j] = k;
                    }
                }
            }
        }

        int link = 0;
        int minValue = Integer.MAX_VALUE;

        for (int i = 0 ; i < 4 ; i++) {
            if (minValue > cost[N][0][i]) {
                minValue = cost[N][0][i];
                link = i;
            }
        }

        for (int i = 0 ; i < N ; i++) {
            minIndex[N - i] = link;
            link = cost[N - i][1][link];
        }

        bw.write(minValue + "\n");
        bw.write(code[minIndex[1]]);
        for (int i = 2 ; i <= N ; i++) {
            if (minIndex[i] == minIndex[i - 1]) {
                bw.write("0");
            } else {
                bw.write("1" + code[minIndex[i]]);
            }
        }

        bw.flush();
        bw.close();
        br.close();
    }
}

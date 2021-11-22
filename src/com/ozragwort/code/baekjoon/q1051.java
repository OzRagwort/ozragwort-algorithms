package com.ozragwort.code.baekjoon;

import java.io.*;
import java.util.*;

public class q1051 {

    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer stk = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(stk.nextToken());
        int M = Integer.parseInt(stk.nextToken());
        int[][] table = new int[N][M];

        for (int i = 0 ; i < N ; i++) {
            String in = br.readLine();
            for (int j = 0 ; j < M ; j++) {
                table[i][j] = in.charAt(j) - 48;
            }
        }

        int max = -1;

        for (int i = 0 ; i < N ; i++) {
            for (int j = 0 ; j < M ; j++) {
                for (int l = Math.min(i, j) ; l > max ; l--) {
                    if (table[i - l][j - l] == table[i][j]
                            && table[i][j - l] == table[i][j]
                            && table[i - l][j] == table[i][j]) {
                        max = l;
                        break;
                    }
                }
            }
        }

        System.out.println((max + 1) * (max + 1));

        br.close();
    }

}

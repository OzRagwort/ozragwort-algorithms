package com.ozragwort.code.baekjoon;

import java.io.*;
import java.util.*;

public class q1145 {
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stk = new StringTokenizer(br.readLine());
        int[] num = new int[5];
        int[][] gcd = new int[5][5];
        int min = Integer.MAX_VALUE;
        int buf = 0;

        for (int i = 0 ; i < 5 ; i++) {
            num[i] = Integer.parseInt(stk.nextToken());
        }

        for (int i = 0 ; i < 5 ; i++) {
            for (int j = i + 1 ; j < 5 ; j++) {
                gcd[i][j] = gcd[j][i] = GCD(num[i], num[j]);
            }
        }

        for (int i = 0 ; i < 5 ; i++) {
            for (int j = i + 1 ; j < 5 ; j++) {
                for (int k = j + 1 ; k < 5 ; k++) {
                    buf = num[i] * num[j] * num[k] / gcd[i][j] / gcd[i][k] / gcd[j][k] * GCD(GCD(gcd[i][j], gcd[i][k]), gcd[j][k]);
                    if (min > buf) {
                        min = buf;
                    }
                }
            }
        }

        System.out.print(min);

    }

    public int GCD(int a, int b) {
        int x = Math.max(a, b);
        int y = Math.min(a, b);

        if (y == 0) {
            return x;
        } else {
            return GCD(y, x % y);
        }
    }
}

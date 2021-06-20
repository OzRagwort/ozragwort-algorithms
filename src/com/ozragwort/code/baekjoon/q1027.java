package com.ozragwort.code.baekjoon;

import java.io.*;
import java.util.StringTokenizer;

public class q1027 {
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] height = new int[N];
        int max = 0;

        StringTokenizer stk = new StringTokenizer(br.readLine());
        for (int i = 0 ; i < N ; i++) {
            height[i] = Integer.parseInt(stk.nextToken());
        }

        for (int i = 0 ; i < N ; i++) {
            int counter = 0;

            double nowInc = 1000000000;
            for (int j = i - 1 ; j >= 0 ; j--) {
                double inc = (double) (height[i] - height[j]) / (double) (i - j);
                if (nowInc > inc) {
                    nowInc = inc;
                    counter++;
                }
            }

            nowInc = -1000000000;
            for (int j = i + 1 ; j < N ; j++) {
                double inc = (double) (height[j] - height[i]) / (double) (j - i);
                if (nowInc < inc) {
                    nowInc = inc;
                    counter++;
                }
            }

            if (max < counter) {
                max = counter;
            }
        }

        System.out.print(max);
    }
}

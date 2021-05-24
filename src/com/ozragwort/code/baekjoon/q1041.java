package com.ozragwort.code.baekjoon;

import java.io.*;
import java.util.*;

public class q1041 {
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        long N = Integer.parseInt(br.readLine());
        int[] num = new int[6];
        StringTokenizer stk = new StringTokenizer(br.readLine());
        int[] min = new int[3];
        long[] counter = new long[3];
        long minCounter = 0;

        for (int i = 0 ; i < 6 ; i++) {
            num[i] = Integer.parseInt(stk.nextToken());
        }

        if (N == 1) {
            Arrays.sort(num);
            for (int i = 0 ; i < 5 ; i++) {
                minCounter += num[i];
            }
            System.out.print(minCounter);
        } else {
            min[0] = Math.min(num[0], num[5]);
            min[1] = Math.min(num[1], num[4]);
            min[2] = Math.min(num[2], num[3]);

            Arrays.sort(min);

            counter[2] = 4;
            counter[1] = counter[2] + 4 * (N - 1) + 4 * (N - 2);
            counter[0] = counter[1] + 5 * ((N - 2) * (N - 2)) + 4 * (N - 2);

            for (int i = 0 ; i < 3 ; i++) {
                minCounter += min[i] * counter[i];
            }

            System.out.print(minCounter);
        }
    }
}

package com.ozragwort.code.baekjoon;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class q2230 {
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stk = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(stk.nextToken());
        int M = Integer.parseInt(stk.nextToken());
        int[] num = new int[N];
        int min = Integer.MAX_VALUE;

        for (int i = 0 ; i < N ; i++) {
            num[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(num);

        int left = 0, right = 0;

        while (right < N && left < N) {
            int sub = num[right] - num[left];
            if (sub >= M) {
                if (min > sub) {
                    min = sub;
                }
                left++;
            } else {
                right++;
            }
        }

        System.out.print(min);
    }
}

package com.ozragwort.code.baekjoon;

import java.io.*;
import java.util.StringTokenizer;

public class q3079 {

    long N, M;
    int[] time;

    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stk = new StringTokenizer(br.readLine());
        N = Integer.parseInt(stk.nextToken());
        M = Integer.parseInt(stk.nextToken());
        time = new int[(int) N];
        int maxTime = 0;

        for (int i = 0 ; i < N ; i++) {
            time[i] = Integer.parseInt(br.readLine());
            if (maxTime < time[i]) {
                maxTime = time[i];
            }
        }

        long left = 1;
        long right = maxTime * M;
        long mid = (left + right) / 2;
        long min = right;

        while (left < right) {
            if (check(mid)) {
                min = mid;
                right = mid;
            } else {
                left = mid + 1;
            }
            mid = (left + right) / 2;
        }

        System.out.print(min);
    }

    public boolean check(long counter) {
        long people = M;
        for (int i = 0 ; i < N ; i++) {
            people -= counter / time[i];
        }
        return people <= 0;
    }
}

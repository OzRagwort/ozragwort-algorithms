package com.ozragwort.code.baekjoon;

import java.io.*;
import java.util.*;

public class q1654 {
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer stk = new StringTokenizer(br.readLine());
        int K = Integer.parseInt(stk.nextToken());
        int N = Integer.parseInt(stk.nextToken());
        int[] lan = new int[K];

        for (int i = 0 ; i < K ; i++) {
            lan[i] = Integer.parseInt(br.readLine());
        }

        int max = maxLength(lan, N, 1, (Integer.MAX_VALUE) / 2, Integer.MAX_VALUE);

        bw.write(Integer.toString(max));

        bw.flush();
        bw.close();
        br.close();
    }

    public int maxLength(int[] lan, int N, int left, int mid, int right) {
        while (left < right) {
            int counter = 0;
            for (int i = 0 ; i < lan.length ; i ++) {
                counter += lan[i] / mid;
            }

            if (counter < N) {
                right = mid - 1;
                mid = left + (right - left) / 2;
            } else {
                left = mid;
                mid = left + (right - left + 1) / 2;
            }
        }

        return mid;
    }
}

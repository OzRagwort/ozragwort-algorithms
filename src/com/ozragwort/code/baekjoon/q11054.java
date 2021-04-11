package com.ozragwort.code.baekjoon;

import java.io.*;
import java.util.*;

public class q11054 {
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer stk;
        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];
        int[] dpUp = new int[N];
        int[] dpDown = new int[N];
        stk = new StringTokenizer(br.readLine());
        int max = Integer.MIN_VALUE;

        for (int i = 0 ; i < N ; i++) {
            arr[i] = Integer.parseInt(stk.nextToken());
        }

        for (int i = 0 ; i < N ; i++) {
            dpUp[i] = 1;
            for (int j = 0 ; j < i ; j++) {
                if (arr[j] < arr[i]) {
                    dpUp[i] = Math.max(dpUp[i], dpUp[j] + 1);
                }
            }
            if (max < dpUp[i])
                max = dpUp[i];
        }
        for (int i = 0 ; i < N ; i++) {
            dpDown[i] = 1;
            for (int j = 0 ; j < i ; j++) {
                if (arr[j] > arr[i]) {
                    dpDown[i] = Math.max(dpDown[i], Math.max(dpDown[j] + 1, dpUp[j] + 1));
                }
            }
            if (max < dpDown[i])
                max = dpDown[i];
        }

        bw.write(Integer.toString(max));

        bw.flush();
        bw.close();
        br.close();
    }

}

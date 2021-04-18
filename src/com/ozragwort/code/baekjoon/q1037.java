package com.ozragwort.code.baekjoon;

import java.io.*;
import java.util.*;

public class q1037 {
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());
        int[] num = new int[N];

        StringTokenizer stk = new StringTokenizer(br.readLine());
        for (int i = 0 ; i < N ; i++) {
            num[i] = Integer.parseInt(stk.nextToken());
        }

        Arrays.sort(num);

        if (N % 2 == 0) {
            bw.write(Integer.toString(num[0] * num[N - 1]));
        } else {
            bw.write(Integer.toString(num[N / 2] * num[N / 2]));
        }

        bw.flush();
        bw.close();
        br.close();
    }
}

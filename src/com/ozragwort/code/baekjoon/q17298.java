package com.ozragwort.code.baekjoon;

import java.io.*;
import java.util.*;

public class q17298 {
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        Stack<Integer[]> stack = new Stack<>();
        int N = Integer.parseInt(br.readLine());
        StringTokenizer stk = new StringTokenizer(br.readLine());
        int[] seq = new int[N + 1];
        int[] nge = new int[N];

        for (int i = 0 ; i < N ; i++) {
            seq[i] = Integer.parseInt(stk.nextToken());
        }

        for (int i = 0 ; i < N ; i++) {
            if (seq[i] < seq[i + 1]) {
                nge[i] = seq[i + 1];
                while (!stack.isEmpty() && stack.peek()[1] < seq[i + 1]) {
                    Integer[] n = stack.pop();
                    nge[n[0]] = seq[i + 1];
                }
            } else {
                stack.push(new Integer[]{i, seq[i]});
            }
        }

        while (!stack.isEmpty()) {
            Integer[] n = stack.pop();
            nge[n[0]] = -1;
        }

        for (int i = 0 ; i < N ; i++) {
            bw.write(nge[i] + " ");
        }

        bw.flush();
        bw.close();
        br.close();
    }
}

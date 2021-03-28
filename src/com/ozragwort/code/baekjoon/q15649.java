package com.ozragwort.code.baekjoon;

import java.io.*;
import java.util.*;

public class q15649 {

    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    boolean[] check;
    int[] arr;
    int N;
    int M;

    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stk = new StringTokenizer(br.readLine());
        N = Integer.parseInt(stk.nextToken());
        M = Integer.parseInt(stk.nextToken());
        check = new boolean[N];
        int depth = 0;

        for (int i = 1 ; i <= N ; i++) {
            arr = new int[M];
            func(depth, i);
        }

        bw.flush();
        bw.close();
        br.close();
    }

    public void func(int depth, int num) throws IOException {

        if (depth == (M - 1)) {
            if (check[num - 1]) {
                return;
            } else {
                arr[depth] = num;
                for (int i = 0 ; i < M ; i++) {
                    bw.write(arr[i] + " ");
                }
                bw.newLine();
            }
        } else {
            if (check[num - 1]) {
                return;
            } else {
                arr[depth] = num;
                check[num - 1] = true;
                depth++;
                for (int i = 1 ; i <= N ; i++) {
                    func(depth, i);
                }
                check[num - 1] = false;
            }
        }
    }

}

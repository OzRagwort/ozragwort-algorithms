package com.ozragwort.code.baekjoon;

import java.io.*;
import java.util.*;

public class q15650 {

    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    int[] arr;
    int N;
    int M;

    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stk = new StringTokenizer(br.readLine());
        N = Integer.parseInt(stk.nextToken());
        M = Integer.parseInt(stk.nextToken());
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
            arr[depth] = num;
            for (int i = 0 ; i < M ; i++) {
                bw.write(arr[i] + " ");
            }
            bw.newLine();
        } else if (depth == 0) {
            arr[depth] = num;
            depth++;
            for (int i = (num + 1) ; i <= N ; i++) {
                func(depth, i);
            }
        } else {
            if (arr[depth - 1] < num) {
                arr[depth] = num;
                depth++;
                for (int i = (num + 1) ; i <= N ; i++) {
                    func(depth, i);
                }
            }
        }
    }

}

package com.ozragwort.code.baekjoon;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class q14889 {

    int N;
    int[][] table;
    int[] arr;
    int[] arr2;
    int min = Integer.MAX_VALUE;

    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        N = Integer.parseInt(br.readLine());
        table = new int[N][N];
        arr = new int[N/2];
        arr2 = new int[N/2];
        int depth = 0;
        StringTokenizer stk;

        for (int i = 0 ; i < N ; i++) {
            stk = new StringTokenizer(br.readLine());
            for (int j = 0 ; j < N ; j++) {
                table[i][j] = Integer.parseInt(stk.nextToken());
            }
        }

        for (int i = 0 ; i <= N/2 ; i++) {
            func(depth, i);
        }

        bw.write(min+"\n");
        bw.flush();
        bw.close();
        br.close();
    }

    public void func(int depth, int index) {
        if (depth == (N / 2) - 1) {
            arr[depth] = index;
            int value = calc();
            if (min > value)
                min = value;
        } else {
            arr[depth] = index;
            for (int i = (index + 1) ; i < N ; i++) {
                func(depth+1, i);
            }
        }
    }

    public int calc() {
        int n = arr.length;
        int value1 = 0;
        int value2 = 0;

        // 1팀 점수
        for (int i = 0 ; i < n ; i++) {
            for (int j = 0 ; j < n ; j++) {
                value1 += table[arr[i]][arr[j]];
            }
        }

        // arr2 채우기
        List<Integer> list = new ArrayList<Integer>();
        for (int i = 0 ; i < N ; i++) {
            list.add(i);
        }
        for (int k : arr) {
            list.remove((Integer) k);
        }
        for (int i = 0 ; i < list.size() ; i++) {
            arr2[i] = list.get(i);
        }

        // 2팀 점수
        for (int i = 0 ; i < n ; i++) {
            for (int j = 0 ; j < n ; j++) {
                value2 += table[arr2[i]][arr2[j]];
            }
        }

        return Math.abs(value1 - value2);
    }

}

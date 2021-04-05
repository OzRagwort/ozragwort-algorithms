package com.ozragwort.code.baekjoon;

import java.io.*;
import java.util.*;

public class q1932 {

    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer stk;
        int max = Integer.MIN_VALUE;
        int N = Integer.parseInt(br.readLine());
        int[][] arr = new int[N][N];

//        입력과 동시에 더 큰 값을 더하면서 최댓값을 구하는 방법
        arr[0][0] = Integer.parseInt(br.readLine());
        for (int i = 1; i < N ; i++) {
            stk = new StringTokenizer(br.readLine());
            arr[i][0] = arr[i - 1][0] + Integer.parseInt(stk.nextToken());

            for (int j = 1; j < i; j++) {
                arr[i][j] = Math.max(arr[i - 1][j - 1], arr[i - 1][j]) + Integer.parseInt(stk.nextToken());
            }

            arr[i][i] = arr[i - 1][i - 1] + Integer.parseInt(stk.nextToken());
        }

//        입력을 모두 받고난 뒤 한번에 계산하고 최대를 구하는 방법 : 240ms
//        for (int i = 0 ; i < N ; i++) {
//            stk = new StringTokenizer(br.readLine());
//            for (int j = 0 ; j <= i ; j++) {
//                arr[i][j] = Integer.parseInt(stk.nextToken());
//            }
//        }
//
//        for (int i = 1 ; i < N ; i++) {
//            arr[i][0] += arr[i-1][0];
//
//            for (int j = 1 ; j < i ; j++) {
//                arr[i][j] += Math.max(arr[i-1][j-1], arr[i-1][j]);
//            }
//
//            arr[i][i] += arr[i-1][i-1];
//        }

        for (int i = 0 ; i < N ; i++) {
            if (max < arr[N-1][i]) {
                max = arr[N-1][i];
            }
        }
        bw.write(Integer.toString(max));

        bw.flush();
        bw.close();
        br.close();
    }

}

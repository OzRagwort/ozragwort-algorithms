package com.ozragwort.code.baekjoon;

import java.io.*;
import java.util.*;

public class q1920 {
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer stk;
        int N = Integer.parseInt(br.readLine());
        int[] A = new int[N];

        stk = new StringTokenizer(br.readLine());
        for (int i = 0 ; i < N ; i++) {
            A[i] = Integer.parseInt(stk.nextToken());
        }

        int M = Integer.parseInt(br.readLine());
        int[] checkArray = new int[M];

        stk = new StringTokenizer(br.readLine());
        for (int i = 0 ; i < M ; i++) {
            checkArray[i] = Integer.parseInt(stk.nextToken());
        }

        Arrays.sort(A);

        for (int i = 0 ; i < M ; i++) {
            String result = findNum(A, checkArray[i]);
            bw.write(result + "\n");
        }

        bw.flush();
        bw.close();
        br.close();
    }

    public String findNum(int[] A, int n) {
        int left = 0;
        int right = A.length - 1;
        int mid = right / 2;

        while (left <= right) {
            if (A[mid] == n) {
                return "1";
            } else if (A[mid] < n) {
                left = mid + 1;
                mid = left + (right - left) / 2;
            } else {
                right = mid - 1;
                mid = left + (right - left) / 2;
            }
        }

        return "0";
    }
}

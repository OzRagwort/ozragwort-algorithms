package com.ozragwort.code.baekjoon;

import java.io.*;
import java.util.*;

public class q10816 {
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
            int result = countNum(A, checkArray[i]);
            bw.write(result + " ");
        }

        bw.flush();
        bw.close();
        br.close();
    }

    public int lower(int[] A, int n, int left, int right, int mid) {
        right = mid;
        mid = left + (right - left) / 2;

        while (left < right) {
            if (A[mid] < n) {
                left = mid + 1;
                mid = left + (right - left) / 2;
            } else {
                right = mid;
                mid = left + (right - left) / 2;
            }
        }

        return mid;
    }

    public int upper(int[] A, int n, int left, int right, int mid) {
        left = mid;
        mid = left + (right - left) / 2;

        while (left < right) {
            if (n < A[mid]) {
                right = mid - 1;
                mid = left + (right - left + 1) / 2;
            } else {
                left = mid;
                mid = left + (right - left + 1) / 2;
            }
        }

        return mid;
    }

    public int countNum(int[] A, int n) {
        int left = 0;
        int right = A.length - 1;
        int mid = right / 2;

        while (left <= right) {
            if (A[mid] == n) {
                return upper(A, n, left, right, mid) - lower(A, n, left, right, mid) + 1;
            } else if (A[mid] < n) {
                left = mid + 1;
                mid = left + (right - left) / 2;
            } else {
                right = mid - 1;
                mid = left + (right - left) / 2;
            }
        }

        return 0;
    }
}

package com.ozragwort.code.baekjoon;

import java.io.*;
import java.util.*;

public class q11651 {
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());
        int[][] arr = new int[N][2];
        StringTokenizer stk;

        for (int i = 0 ; i < N ; i++) {
            stk = new StringTokenizer(br.readLine());
            arr[i][0] = Integer.parseInt(stk.nextToken());
            arr[i][1] = Integer.parseInt(stk.nextToken());
        }

        arr = mergeSort(arr, 0, N - 1);

        for (int i = 0 ; i < N ; i++) {
            bw.write(arr[i][0] + " " + arr[i][1] + "\n");
        }

        bw.flush();
        bw.close();
        br.close();
    }

    public int[][] mergeSort(int[][] arr, int first, int end) {
        int left = (end - first + 1) / 2;
        int right = (end - first + 1) - left;
        int mid = first + left;

        if ((end - first) >= 1) {
            arr = mergeSort(arr, first, first + left - 1);
            arr = mergeSort(arr, mid, mid + right - 1);
            arr = merge(arr, first, mid, end);
        }

        return arr;
    }

    public int[][] merge(int[][] arr, int first, int mid, int end) {
        int[][] ret = new int[end - first + 1][2];
        int i = 0;
        int indexL = first;
        int indexR = mid;
        while((indexL < mid) && (indexR <= end)) {
            if (arr[indexL][1] < arr[indexR][1]) {
                ret[i] = arr[indexL];
                indexL++;
            } else if (arr[indexL][1] == arr[indexR][1]) {
                if (arr[indexL][0] < arr[indexR][0]) {
                    ret[i] = arr[indexL];
                    indexL++;
                } else {
                    ret[i] = arr[indexR];
                    indexR++;
                }
            } else {
                ret[i] = arr[indexR];
                indexR++;
            }
            i++;
        }
        if (indexL < mid) {
            while(indexL < mid) {
                ret[i] = arr[indexL];
                i++;
                indexL++;
            }
        } else {
            while(indexR <= end) {
                ret[i] = arr[indexR];
                i++;
                indexR++;
            }
        }
        System.arraycopy(ret, 0, arr, first, ret.length);
        return arr;
    }
}
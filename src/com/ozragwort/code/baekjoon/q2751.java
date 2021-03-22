package com.ozragwort.code.baekjoon;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class q2751 {
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());
//        Collections.sort
//        List<Integer> list = new ArrayList<>();
//        for (int i = 0 ; i < N ; i++) {
//            list.add(Integer.parseInt(br.readLine()));
//        }
//
//        Collections.sort(list);
//        for (int i : list) {
//            bw.write(i + "\n");
//        }

//         merge sort
        int[] arr = new int[N];
        for (int i = 0 ; i < N ; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        arr = mergeSort(arr, 0, N - 1);

        for (int i = 0 ; i < N ; i++) {
            bw.write(arr[i] + "\n");
        }
        bw.flush();
        bw.close();
        br.close();
    }

    public int[] mergeSort(int[] arr, int first, int end) {
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

    public int[] merge(int[] arr, int first, int mid, int end) {
        int[] ret = new int[end - first + 1];
        int i = 0;
        int indexL = first;
        int indexR = mid;
        while((indexL < mid) && (indexR <= end)) {
            if (arr[indexL] < arr[indexR]) {
                ret[i] = arr[indexL];
                indexL++;
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
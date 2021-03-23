package com.ozragwort.code.baekjoon;

import java.io.*;

public class q1427 {
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String N = br.readLine();
        char[] arr = new char[N.length()];

        for (int i = 0 ; i < N.length() ; i++) {
            arr[i] = N.charAt(i);
        }

        arr = mergeSort(arr, 0, N.length() - 1);

        String S = String.valueOf(arr);
        bw.write(S);

        bw.flush();
        bw.close();
        br.close();
    }

    public char[] mergeSort(char[] arr, int first, int end) {
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

    public char[] merge(char[] arr, int first, int mid, int end) {
        char[] ret = new char[end - first + 1];
        int i = 0;
        int indexL = first;
        int indexR = mid;
        while((indexL < mid) && (indexR <= end)) {
            if (arr[indexL] > arr[indexR]) {
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
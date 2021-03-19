package com.ozragwort.code.baekjoon;

import java.io.*;

public class q2750 {
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];

        for (int i = 0 ; i < N ; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        arr = insertSort(arr);
//        arr = bubbleSort(arr);

        for (int i = 0 ; i < N ; i++) {
            bw.write(Integer.toString(arr[i]));
            bw.newLine();
        }

        bw.flush();
        bw.close();
        br.close();
    }

    public int[] insertSort(int[] arr) {
        int buffer = 0;
        for (int i = 1 ; i < arr.length ; i++) {
            for (int j = i ; j > 0 ; j--) {
                if (arr[j - 1] > arr[j]) {
                    buffer = arr[j];
                    arr[j] = arr[j - 1];
                    arr[j - 1] = buffer;
                }
            }
        }
        return arr;
    }

    public int[] bubbleSort(int[] arr) {
        int buffer = 0;
        for (int i = 1 ; i < arr.length ; i++) {
            for (int j = 0 ; j < arr.length - i ; j++) {
                if (arr[j] > arr[j + 1]) {
                    buffer = arr[j + 1];
                    arr[j + 1] = arr[j];
                    arr[j] = buffer;
                }
            }
        }
        return arr;
    }
}

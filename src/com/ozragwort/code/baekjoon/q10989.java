package com.ozragwort.code.baekjoon;

import java.io.*;

public class q10989 {
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());
        int[] sortArr = new int[N];
        int[] inputArr = new int[N];
        int[] countArr;
        int max = 0;

        for (int i = 0 ; i < N ; i++) {
            inputArr[i] = Integer.parseInt(br.readLine());
            if (max < inputArr[i]) {
                max = inputArr[i];
            }
        }

        countArr = new int[max+1];

        for (int i = 0 ; i < N ; i++) {
            countArr[inputArr[i]]++;
        }

        for (int i = 1 ; i < max+1 ; i++) {
            countArr[i] += countArr[i-1];
        }

        for (int i = 0 ; i < N ; i++) {
            sortArr[--countArr[inputArr[i]]] = inputArr[i];
        }

        for (int i = 0 ; i < N ; i++) {
            bw.write(sortArr[i] + "\n");
        }

        bw.flush();
        bw.close();
        br.close();
    }
}

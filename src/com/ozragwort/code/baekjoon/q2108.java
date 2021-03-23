package com.ozragwort.code.baekjoon;

import java.io.*;
import java.util.Arrays;

public class q2108 {
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];
        int sum = 0;
        int midValue = 0;
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        int[] freq = new int[8001];
        int freqMax = Integer.MIN_VALUE;
        int freqCount = 1;
        int freqMaxNum = 0;

        // 입력
        for (int i = 0 ; i < N ; i++) {
            arr[i] = Integer.parseInt(br.readLine());
            if (arr[i] < min)
                min = arr[i];
            if (max < arr[i])
                max = arr[i];
            freq[arr[i] + 4000]++;
            sum += arr[i];
        }

        // 정렬
        Arrays.sort(arr);
        midValue = arr[N/2];

        // 빈도계산
        for (int i = 0 ; i < 8001 ; i++) {
            if (freqMax < freq[i]) {
                freqMax = freq[i];
            }
        }
        for (int i = 0 ; i < 8001 ; i++) {
            if (freqMax == freq[i]) {
                if (freqCount > 0) {
                    freqMaxNum = i - 4000;
                    freqCount--;
                }
                else if (freqCount == 0) {
                    freqMaxNum = i - 4000;
                    break;
                }
            }
        }

        bw.write(Math.round((double) sum / (double) N) + "\n");
        bw.write(midValue + "\n");
        bw.write(freqMaxNum + "\n");
        bw.write((max - min) + "\n");

        bw.flush();
        bw.close();
        br.close();
    }
}
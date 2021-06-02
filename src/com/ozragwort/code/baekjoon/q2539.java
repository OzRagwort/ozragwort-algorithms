package com.ozragwort.code.baekjoon;

import java.io.*;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class q2539 {

    int paper, wrong;
    int[][] wrongNum;

    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stk = new StringTokenizer(br.readLine().trim());
        int N = Integer.parseInt(stk.nextToken());
        int M = Integer.parseInt(stk.nextToken());
        paper = Integer.parseInt(br.readLine().trim());
        wrong = Integer.parseInt(br.readLine().trim());
        wrongNum = new int[wrong][2];
        int maxHeight = 0;
        int firstX = Integer.MAX_VALUE, endX = 0;

        for (int w = 0 ; w < wrong ; w++) {
            stk = new StringTokenizer(br.readLine().trim());
            wrongNum[w][0] = Integer.parseInt(stk.nextToken());
            wrongNum[w][1] = Integer.parseInt(stk.nextToken());
            if (maxHeight < wrongNum[w][0]) {
                maxHeight = wrongNum[w][0];
            }
            if (firstX > wrongNum[w][1]) {
                firstX = wrongNum[w][1];
            }
            if (endX < wrongNum[w][1]) {
                endX = wrongNum[w][1];
            }
        }

        Arrays.sort(wrongNum, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if (o1[1] == o2[1]) {
                    return o1[0] - o2[0];
                } else {
                    return o1[1] - o2[1];
                }
            }
        });

        int left = maxHeight;
        int right = Math.max(maxHeight, endX - firstX + 1);
        int mid = (left + right) / 2;

        while (left < right) {
            if (check(mid)) {
                right = mid;
                mid = (left + mid) / 2;
            } else {
                left = mid + 1;
                mid = (right + left) / 2;
            }
        }

        System.out.println(mid);
    }

    public boolean check(int paperLength) {
        int p = 0;
        int paperIndex = 1;

        for (int i = 0 ; i < wrong ; i++) {
            if (wrongNum[i][1] >= paperIndex) {
                if (p == paper) {
                    return false;
                } else {
                    paperIndex = wrongNum[i][1] + paperLength;
                    p++;
                }
            }
        }

        return true;
    }
}

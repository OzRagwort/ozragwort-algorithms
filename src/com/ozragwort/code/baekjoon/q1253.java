package com.ozragwort.code.baekjoon;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class q1253 {

    int N;
    long[] num;

    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine().trim());
        StringTokenizer stk = new StringTokenizer(br.readLine().trim());
        num = new long[N];
        int counter = 0;

        for (int i = 0 ; i < N ; i++) {
            num[i] = Integer.parseInt(stk.nextToken());
        }

        Arrays.sort(num);

        for (int i = 0 ; i < N ; i++) {
            if (check(i)) {
                counter++;
            }
        }

        System.out.print(counter);
    }

    public boolean check(int i) {
        int start = 0;
        int end = num.length - 1;

        while (start != end) {
            if (num[i] < num[start] + num[end]) {
                end--;
            } else if (num[i] > num[start] + num[end]) {
                start++;
            } else {
                if (i == start) {
                    start++;
                } else if (i == end) {
                    end--;
                } else {
                    return true;
                }
            }
        }
        return false;
    }
}

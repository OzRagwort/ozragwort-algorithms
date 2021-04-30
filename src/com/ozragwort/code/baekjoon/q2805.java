package com.ozragwort.code.baekjoon;

import java.io.*;
import java.util.*;

public class q2805 {
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer stk = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(stk.nextToken());
        int M = Integer.parseInt(stk.nextToken());
        int[] tree = new int[N];

        stk = new StringTokenizer(br.readLine());
        for (int i = 0 ; i < N ; i++) {
            tree[i] = Integer.parseInt(stk.nextToken());
        }

        int h = getHeight(tree, M, 0, 500000000, 1000000000);

        bw.write(Integer.toString(h));

        bw.flush();
        bw.close();
        br.close();
    }

    public int getHeight(int[] tree, int M, int left, int mid, int right) {
        while (left < right) {
            long cutLength = 0;
            for (int t : tree) {
                int l = t - mid;
                if (l > 0) {
                    cutLength += l;
                }
            }

            if (M <= cutLength) {
                left = mid;
                mid = left + ((right - left + 1) / 2);
            } else {
                right = mid - 1;
                mid = left + ((right - left + 1) / 2);
            }
        }

        return mid;
    }
}

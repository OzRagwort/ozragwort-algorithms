package com.ozragwort.code.baekjoon;

import java.io.*;
import java.util.*;

public class q14247 {
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stkL, stkG;
        int N = Integer.parseInt(br.readLine());
        int[][] length = new int[N][2];
        long totalLength = 0;

        stkL = new StringTokenizer(br.readLine());
        stkG = new StringTokenizer(br.readLine());
        for (int i = 0 ; i < N ; i++) {
            length[i][0] = Integer.parseInt(stkL.nextToken());
            length[i][1] = Integer.parseInt(stkG.nextToken());
        }

        Arrays.sort(length, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[1] - o2[1];
            }
        });

        for (int i = 0 ; i < N ; i++) {
            totalLength += length[i][0] + (length[i][1] * i);
        }

        System.out.print(totalLength);
    }
}

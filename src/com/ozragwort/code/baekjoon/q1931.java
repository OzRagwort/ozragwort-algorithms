package com.ozragwort.code.baekjoon;

import java.io.*;
import java.util.*;

public class q1931 {
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer stk;
        int N = Integer.parseInt(br.readLine());
        int[][] room = new int[N][2];
        int max = 0;
        int time = 0;

        for (int i = 0 ; i < N ; i++) {
            stk = new StringTokenizer(br.readLine());
            room[i][0] = Integer.parseInt(stk.nextToken());
            room[i][1] = Integer.parseInt(stk.nextToken());
        }

        Arrays.sort(room, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if (o1[1] == o2[1]) {
                    return o1[0] - o2[0];
                }
                return o1[1] - o2[1];
            }
        });

        for (int i = 0 ; i < N ; i++) {
            if (room[i][0] >= time) {
                time = room[i][1];
                max++;
            }
        }

        bw.write(Integer.toString(max));

        bw.flush();
        bw.close();
        br.close();
    }
}

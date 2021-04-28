package com.ozragwort.code.baekjoon;

import java.io.*;
import java.util.*;

public class q2630 {

    boolean[][] table;
    int[] counter = new int[2];

    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer stk;
        int N = Integer.parseInt(br.readLine());
        table = new boolean[N][N];

        for (int i = 0 ; i < N ; i++) {
            stk = new StringTokenizer(br.readLine());
            for (int j = 0 ; j < N ; j++) {
                table[i][j] = stk.nextToken().equals("1");
            }
        }

        counterPaper(0, 0, N);

        bw.write(counter[0] + "\n" + counter[1]);

        bw.flush();
        bw.close();
        br.close();
    }

    public void counterPaper(int x, int y, int length) {

        if (length == 1) {
            if (table[x][y]) {
                counter[1]++;
            } else {
                counter[0]++;
            }
        } else {
            boolean check = table[x][y];
            for (int i = x ; i < x + length ; i++) {
                for (int j = y ; j < y + length ; j++) {
                    if (check != table[i][j]) {
                        counterPaper(x, y, length / 2);
                        counterPaper(x + (length / 2), y, length / 2);
                        counterPaper(x, y + (length / 2), length / 2);
                        counterPaper(x + (length / 2), y + (length / 2), length / 2);
                        return;
                    }
                }
            }
            if (check) {
                counter[1]++;
            } else {
                counter[0]++;
            }
        }
    }
}

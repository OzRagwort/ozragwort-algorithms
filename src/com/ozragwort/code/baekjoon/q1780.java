package com.ozragwort.code.baekjoon;

import java.io.*;
import java.util.*;

public class q1780 {

    int[][] table;
    int[] counter = new int[3];

    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer stk;
        int N = Integer.parseInt(br.readLine());
        table = new int[N][N];

        for (int i = 0 ; i < N ; i++) {
            stk = new StringTokenizer(br.readLine());
            for (int j = 0 ; j < N ; j++) {
                table[i][j] = Integer.parseInt(stk.nextToken());
            }
        }

        counterPaper(0, 0, N);

        bw.write(counter[0] + "\n" + counter[1] + "\n" + counter[2]);

        bw.flush();
        bw.close();
        br.close();
    }

    public void counterPaper(int x, int y, int length) {
        if (length == 1) {
            if (table[x][y] == -1) {
                counter[0]++;
            } else if (table[x][y] == 0){
                counter[1]++;
            } else {
                counter[2]++;
            }
        } else {
            int check = table[x][y];
            for (int i = x ; i < x + length ; i++) {
                for (int j = y ; j < y + length ; j++) {
                    if (check != table[i][j]) {
                        for (int fx = x ; fx < x + length ; fx += length / 3) {
                            for (int fy = y ; fy < y + length ; fy += length / 3) {
                                counterPaper(fx, fy, length / 3);
                            }
                        }
                        return;
                    }
                }
            }
            if (check == -1) {
                counter[0]++;
            } else if (check == 0) {
                counter[1]++;
            } else {
                counter[2]++;
            }
        }
    }
}

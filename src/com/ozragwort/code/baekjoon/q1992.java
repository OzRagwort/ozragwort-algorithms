package com.ozragwort.code.baekjoon;

import java.io.*;
import java.util.*;

public class q1992 {

    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    boolean[][] table;

    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        table = new boolean[N][N];

        for (int i = 0 ; i < N ; i++) {
            String s = br.readLine();
            for (int j = 0 ; j < N ; j++) {
                table[i][j] = s.charAt(j) == '1';
            }
        }

        counterPaper(0, 0, N);

        bw.flush();
        bw.close();
        br.close();
    }

    public void counterPaper(int x, int y, int length) throws IOException {
        if (length == 1) {
            if (table[x][y]) {
                bw.write("1");
            } else {
                bw.write("0");
            }
        } else {
            boolean check = table[x][y];
            for (int i = x ; i < x + length ; i++) {
                for (int j = y ; j < y + length ; j++) {
                    if (check != table[i][j]) {
                        bw.write("(");
                        counterPaper(x, y, length / 2);
                        counterPaper(x, y + (length / 2), length / 2);
                        counterPaper(x + (length / 2), y, length / 2);
                        counterPaper(x + (length / 2), y + (length / 2), length / 2);
                        bw.write(")");
                        return;
                    }
                }
            }
            if (check) {
                bw.write("1");
            } else {
                bw.write("0");
            }
        }
    }
}

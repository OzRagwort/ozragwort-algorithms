package com.ozragwort.code.baekjoon;

import java.io.*;
import java.util.StringTokenizer;

public class q16956 {

    char[][] table;
    int[] dx = new int[]{0, 0, 1, -1};
    int[] dy = new int[]{1, -1, 0, 0};

    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer stk = new StringTokenizer(br.readLine());
        int R = Integer.parseInt(stk.nextToken());
        int C = Integer.parseInt(stk.nextToken());
        table = new char[R + 2][C + 2];

        for (int i = 1 ; i <= R ; i++) {
            String s = br.readLine();
            for (int j = 1 ; j <= C ; j++) {
                char c = s.charAt(j - 1);
                if (c == '.') {
                    table[i][j] = 'D';
                } else {
                    table[i][j] = c;
                }
            }
        }

        boolean meet = false;
        for (int i = 1 ; i <= R ; i++) {
            for (int j = 1 ; j <= C ; j++) {
                if (table[i][j] == 'W') {
                    meet = check(i, j);
                }
            }
        }

        if (meet) {
            bw.write("0");
        } else {
            bw.write("1\n");
            for (int i = 1 ; i <= R ; i++) {
                for (int j = 1 ; j <= C ; j++) {
                    bw.write(table[i][j]);
                }
                bw.newLine();
            }
        }

        bw.flush();
        bw.close();
        br.close();
    }

    public boolean check(int a, int b) {
        for (int i = 0 ; i < 4 ; i++) {
            int x = a + dx[i];
            int y = b + dy[i];

            if (table[x][y] == 'S') {
                return true;
            }
        }
        return false;
    }
}

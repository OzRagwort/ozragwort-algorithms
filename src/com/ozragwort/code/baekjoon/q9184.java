package com.ozragwort.code.baekjoon;

import java.io.*;
import java.util.*;

public class q9184 {

    int[][][] table = new int[20][20][20];

    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer stk;

        while (true) {
            stk = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(stk.nextToken());
            int b = Integer.parseInt(stk.nextToken());
            int c = Integer.parseInt(stk.nextToken());
            int result = 0;
            if (a == -1 && b == -1 && c == -1) {
                break;
            } else {
                result = func(a, b, c);
            }
            bw.write("w(" + a + ", " + b + ", " + c + ") = " + result + "\n");
        }

        bw.flush();
        bw.close();
        br.close();
    }

    public int func(int a, int b, int c) {
        if (a <= 0 || b <= 0 || c <= 0) {
            return 1;
        } else if (a > 20 || b > 20 || c > 20) {
            if (table[19][19][19] == 0) {
                table[19][19][19] = func(20, 20, 20);
            }
            return table[19][19][19];
        } else if (a < b && b < c) {
            if (table[a-1][b-1][c-1] == 0) {
                table[a-1][b-1][c-1] = func(a, b, c-1) + func(a, b-1, c-1) - func(a, b-1, c);
            }
            return table[a-1][b-1][c-1];
        } else {
            if (table[a-1][b-1][c-1] == 0) {
                table[a-1][b-1][c-1] = func(a-1, b, c) + func(a-1, b-1, c) + func(a-1, b, c-1) - func(a-1, b-1, c-1);
            }
            return table[a-1][b-1][c-1];
        }
    }

}

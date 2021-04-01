package com.ozragwort.code.baekjoon;

import java.io.*;
import java.util.StringTokenizer;

public class q2580 {

    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    boolean clear = false;

    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[][] table = new int[9][9];
        StringTokenizer stk;

        for (int i = 0 ; i < 9 ; i++) {
            stk = new StringTokenizer(br.readLine());
            for (int j = 0 ; j < 9 ; j++) {
                table[i][j] = Integer.parseInt(stk.nextToken());
            }
        }

        func(table, 0);

        bw.flush();
        bw.close();
        br.close();
    }

    public void func(int[][] table, int index) throws IOException {
        while (index < 81) {
            if (table[index/9][index%9] == 0) {
                for (int i = 1 ; i <= 9 ; i++) {
                    if (check(table, index/9, index%9, i)) {
                        table[index/9][index%9] = i;
                        func(table, index);
                        if (clear)
                            break;
                        table[index/9][index%9] = 0;
                    }
                }
                return;
            }
            if (clear)
                break;
            index++;
        }
        if (index == 81) {
            for (int i = 0 ; i < 9 ; i++) {
                for (int j = 0; j < 9; j++) {
                    bw.write(table[i][j] + " ");
                }
                bw.newLine();
            }
            clear = true;
        }
    }

    public boolean check(int[][] table, int x, int y, int n) {
        int firstx = (x / 3) * 3;
        int firsty = (y / 3) * 3;
        for (int i = 0 ; i < 9 ; i++) {
            if ((table[x][i] == n) || (table[i][y] == n))
                return false;
        }
        for (int i = firstx ; i < firstx + 3 ; i++) {
            for (int j = firsty ; j < firsty + 3 ; j++) {
                if (table[i][j] == n)
                    return false;
            }
        }
        return true;
    }

}

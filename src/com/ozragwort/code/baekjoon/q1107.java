package com.ozragwort.code.baekjoon;

import java.io.*;
import java.util.*;

public class q1107 {

    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String strN = br.readLine();
        int M = Integer.parseInt(br.readLine());
        boolean[] breakButton = new boolean[10];

        if (M > 0) {
            StringTokenizer stk = new StringTokenizer(br.readLine());
            for (int i = 0 ; i < M ; i++) {
                int m = Integer.parseInt(stk.nextToken());
                breakButton[m] = true;
            }
        }

        int N = Integer.parseInt(strN);
        int justMoveCount = Math.abs(N - 100);
        int buttonMoveCount = Integer.MAX_VALUE;

        for (int i = 0 ; i < justMoveCount ; i++) {
            if (N >= i && check(breakButton, N - i)) {
                int len = Integer.toString(N - i).length();
                buttonMoveCount = Math.min(justMoveCount, i + len);
                break;
            }
            if (check(breakButton, N + i)) {
                int len = Integer.toString(N + i).length();
                buttonMoveCount = Math.min(justMoveCount, i + len);
                break;
            }
        }

        System.out.println(Math.min(justMoveCount, buttonMoveCount));

        br.close();
    }

    public boolean check(boolean[] breakButton, int N) {
        do {
            int n = N % 10;
            if (breakButton[n]) {
                return false;
            }
            N /= 10;
        } while (N > 0);
        return true;
    }

}

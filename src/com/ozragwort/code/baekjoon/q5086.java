package com.ozragwort.code.baekjoon;

import java.io.*;
import java.util.*;

public class q5086 {
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer stk;

        while (true) {
            stk = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(stk.nextToken());
            int b = Integer.parseInt(stk.nextToken());
            if (a == 0 && b == 0) {
                break;
            } else if (b % a == 0) {
                bw.write("factor\n");
            } else if (a % b == 0) {
                bw.write("multiple\n");
            } else {
                bw.write("neither\n");
            }
        }

        bw.flush();
        bw.close();
        br.close();
    }
}

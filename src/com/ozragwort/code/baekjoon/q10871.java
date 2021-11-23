package com.ozragwort.code.baekjoon;

import java.io.*;
import java.util.*;

public class q10871 {

    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer stk = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(stk.nextToken());
        int X = Integer.parseInt(stk.nextToken());
        stk = new StringTokenizer(br.readLine());

        while (stk.hasMoreTokens()) {
            int n = Integer.parseInt(stk.nextToken());
            if (n < X) {
                bw.write(n + " ");
            }
        }

        bw.flush();
        bw.close();
        br.close();
    }

}

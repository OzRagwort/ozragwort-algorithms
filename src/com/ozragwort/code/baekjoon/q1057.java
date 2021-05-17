package com.ozragwort.code.baekjoon;

import java.io.*;
import java.util.*;

public class q1057 {
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stk = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(stk.nextToken());
        int x = Integer.parseInt(stk.nextToken());
        int y = Integer.parseInt(stk.nextToken());
        int counter = 0;

        while (x != y) {
            x = (x + 1) / 2;
            y = (y + 1) / 2;
            counter++;
        }

        System.out.print(counter);
    }
}

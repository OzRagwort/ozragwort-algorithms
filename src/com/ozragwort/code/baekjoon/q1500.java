package com.ozragwort.code.baekjoon;

import java.io.*;
import java.util.*;

public class q1500 {

    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer stk = new StringTokenizer(br.readLine());
        int S = Integer.parseInt(stk.nextToken());
        int K = Integer.parseInt(stk.nextToken());
        int n = S / K;
        long result = 1;

        for (int i = 0 ; i < S % K ; i++) {
            result *= n + 1;
        }

        for (int i = S % K ; i < K ; i++) {
            result *= n;
        }

        System.out.println(result);

        br.close();
    }

}

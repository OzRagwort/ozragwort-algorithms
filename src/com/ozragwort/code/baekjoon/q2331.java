package com.ozragwort.code.baekjoon;

import java.io.*;
import java.util.HashMap;
import java.util.StringTokenizer;

public class q2331 {
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stk = new StringTokenizer(br.readLine());
        int A = Integer.parseInt(stk.nextToken());
        int P = Integer.parseInt(stk.nextToken());
        HashMap<Integer, Integer> map = new HashMap<>();
        int counter = 0;

        int next = A;
        int now = next;
        while (!map.containsKey(next)) {
            map.put(next, counter);
            counter++;

            now = next;
            next = 0;
            while (now > 0) {
                next += Math.pow(now % 10, P);
                now /= 10;
            }
        }

        System.out.print(map.get(next));
    }
}

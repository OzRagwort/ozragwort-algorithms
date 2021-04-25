package com.ozragwort.code.baekjoon;

import java.io.*;
import java.util.*;

public class q11866 {
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        LinkedList<Integer> q = new LinkedList<>();
        StringTokenizer stk = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(stk.nextToken());
        int K = Integer.parseInt(stk.nextToken());

        for (int i = 1 ; i <= N ; i++) {
            q.offer(i);
        }

        bw.write("<");
        while (true) {
            for (int i = 0 ; i < K - 1 ; i++) {
                q.offer(q.poll());
            }
            bw.write(Integer.toString(q.poll()));
            if (q.isEmpty()) {
                break;
            } else {
                bw.write(", ");
            }
        }
        bw.write(">");

        bw.flush();
        bw.close();
        br.close();
    }
}

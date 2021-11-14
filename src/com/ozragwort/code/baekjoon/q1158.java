 package com.ozragwort.code.baekjoon;

import java.io.*;
import java.util.*;

public class q1158 {

    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer stk = new StringTokenizer(br.readLine());
        List<Integer> list = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(stk.nextToken());
        int K = Integer.parseInt(stk.nextToken());

        for (int i = 1 ; i <= N ; i++) {
            list.add(i);
        }

        int i = 0;
        sb.append("<");
        while (!list.isEmpty()) {
            i = (i + K - 1) % list.size();
            sb.append(list.remove(i)).append(", ");
        }
        sb.delete(sb.length() - 2, sb.length());
        sb.append(">");

        System.out.println(sb.toString());

        bw.flush();
        bw.close();
        br.close();
    }

}

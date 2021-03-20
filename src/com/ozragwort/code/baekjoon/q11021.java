package com.ozragwort.code.baekjoon;

import java.io.*;
import java.util.StringTokenizer;

public class q11021 {
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());

        for (int i = 1 ; i <= N ; i++) {
            StringTokenizer stk = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(stk.nextToken());
            int b = Integer.parseInt(stk.nextToken());
            bw.write("Case #" + i + ": " + (a + b) + "\n");
        }

        bw.flush();
        bw.close();
        br.close();
    }
}

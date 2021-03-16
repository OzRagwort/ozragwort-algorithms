package com.ozragwort.code.baekjoon;

import java.io.*;

public class q3009 {
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] L1 = br.readLine().split(" ");
        String[] L2 = br.readLine().split(" ");
        String[] L3 = br.readLine().split(" ");

        bw.write(L1[0].equals(L2[0]) ? L3[0] : (L1[0].equals(L3[0]) ? L2[0] : L1[0]));
        bw.write(" ");
        bw.write(L1[1].equals(L2[1]) ? L3[1] : (L1[1].equals(L3[1]) ? L2[1] : L1[1]));

        bw.flush();
        bw.close();
        br.close();
    }
}

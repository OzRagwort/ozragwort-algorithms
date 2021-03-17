package com.ozragwort.code.baekjoon;

import java.io.*;

public class q3053 {
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int R = Integer.parseInt(br.readLine());
        double round_pi = R * R * Math.PI;
        double round_taxi = R * R * 2;

        bw.write(String.format("%.6f", round_pi));
        bw.newLine();
        bw.write(String.format("%.6f", round_taxi));

        bw.flush();
        bw.close();
        br.close();
    }
}

package com.ozragwort.code.baekjoon;

import java.io.*;

public class q2675 {
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());

        for (int i = 0 ; i < N ; i++) {
            StringBuilder P = new StringBuilder();
            String values = br.readLine();
            String[] value = values.split(" ");
            for (int x = 0 ; x < value[1].length() ; x++) {
                for (int y = 0 ; y < Integer.parseInt(value[0]) ; y++) {
                    P.append(value[1].charAt(x));
                }
            }
            bw.write(P.toString());
            bw.newLine();
        }

        bw.flush();
        bw.close();
        br.close();
    }
}

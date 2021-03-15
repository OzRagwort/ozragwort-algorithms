package com.ozragwort.code.baekjoon;

import java.io.*;

public class q1152 {
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String N = br.readLine();
        String[] str = N.split(" ");
        int counter = 0;

        for (String s : str) {
            if (s.length() != 0)
                counter++;
        }

        System.out.println(counter);

        bw.flush();
        bw.close();
        br.close();
    }
}

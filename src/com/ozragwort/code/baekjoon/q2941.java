package com.ozragwort.code.baekjoon;

import java.io.*;

public class q2941 {
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String str = br.readLine();
        int counter = 0;

        for (int i = 0 ; i < str.length() ; i++) {
            if (str.startsWith("c=", i)) {
                i++;
            } else if (str.startsWith("c-", i)) {
                i++;
            } else if (str.startsWith("dz=", i)) {
                i+=2;
            } else if (str.startsWith("d-", i)) {
                i++;
            } else if (str.startsWith("lj", i)) {
                i++;
            } else if (str.startsWith("nj", i)) {
                i++;
            } else if (str.startsWith("s=", i)) {
                i++;
            } else if (str.startsWith("z=", i)) {
                i++;
            }
            counter++;
        }

        System.out.println(counter);

        bw.flush();
        bw.close();
        br.close();
    }
}

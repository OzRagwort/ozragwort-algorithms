package com.ozragwort.code.baekjoon;

import java.io.*;

public class q2908 {
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String[] str = br.readLine().split(" ");
        String[] revStr = new String[str.length];
        String buffer = "";

        for (int i = 0 ; i < str.length ; i++) {
            for (int j = str[i].length()-1 ; j >= 0 ; j--) {
                buffer += String.valueOf(str[i].charAt(j));
            }
            revStr[i] = buffer;
            buffer = "";
        }

        System.out.println(Integer.parseInt(revStr[0]) > Integer.parseInt(revStr[1]) ? revStr[0] : revStr[1]);

        bw.flush();
        bw.close();
        br.close();
    }
}

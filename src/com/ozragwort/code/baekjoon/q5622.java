package com.ozragwort.code.baekjoon;

import java.io.*;

public class q5622 {
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String str = br.readLine();
        int time = 0;

        for (int i = 0 ; i < str.length() ; i++) {
            if ("ABC".contains(String.valueOf(str.charAt(i))))
                time += 3;
            else if ("DEF".contains(String.valueOf(str.charAt(i))))
                time += 4;
            else if ("GHI".contains(String.valueOf(str.charAt(i))))
                time += 5;
            else if ("JKL".contains(String.valueOf(str.charAt(i))))
                time += 6;
            else if ("MNO".contains(String.valueOf(str.charAt(i))))
                time += 7;
            else if ("PQRS".contains(String.valueOf(str.charAt(i))))
                time += 8;
            else if ("TUV".contains(String.valueOf(str.charAt(i))))
                time += 9;
            else
                time += 10;
        }

        System.out.println(time);

        bw.flush();
        bw.close();
        br.close();
    }
}

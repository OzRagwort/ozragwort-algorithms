package com.ozragwort.code.baekjoon;

import java.io.*;

public class q10951 {
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        while(true) {
            String input = br.readLine();
            if (input == null) {
                break;
            } else {
                String[] array = input.split(" ");
                bw.write(Integer.toString(Integer.parseInt(array[0]) + Integer.parseInt(array[1])));
                bw.newLine();
            }
        }

        bw.flush();
        bw.close();
        br.close();
    }
}

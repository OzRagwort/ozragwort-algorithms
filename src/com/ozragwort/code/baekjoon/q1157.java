package com.ozragwort.code.baekjoon;

import java.io.*;

public class q1157 {
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String N = br.readLine();
        N = N.toUpperCase();
        int[] arr = new int[26];
        int max = 0;
        boolean equalCheck = false;

        for (int i = 0 ; i < N.length() ; i++) {
            arr[(int) N.charAt(i) - 65]++;
        }
        for (int i = 1 ; i < 26 ; i++) {
            if (arr[max] <= arr[i]) {
                equalCheck = (arr[max] == arr[i]);
                max = i;
            }
        }
        if (equalCheck) {
            bw.write("?");
        } else {
            bw.write((char) (max + 65));
        }

        bw.flush();
        bw.close();
        br.close();
    }
}

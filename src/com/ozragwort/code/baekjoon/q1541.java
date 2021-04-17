package com.ozragwort.code.baekjoon;

import java.io.*;

public class q1541 {
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String in = br.readLine();
        String[] splitSub = in.split("-");
        int[] arraySplitSub = new int[splitSub.length];
        int min;

        for (int i = 0 ; i < splitSub.length ; i++) {
            String[] n = splitSub[i].split("\\+");
            for (int j = 0 ; j < n.length ; j++) {
                arraySplitSub[i] += Integer.parseInt(n[j]);
            }
        }

        min = arraySplitSub[0];
        for (int i = 1 ; i < arraySplitSub.length ; i++) {
            min -= arraySplitSub[i];
        }

        bw.write(Integer.toString(min));

        bw.flush();
        bw.close();
        br.close();
    }
}

package com.ozragwort.code.baekjoon;

import java.io.*;

public class q1543 {
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String fullText = br.readLine();
        String target = br.readLine();

        int count = 0;
        int targetTextLength = target.length();

        for (int i = 0 ; i <= fullText.length() - targetTextLength ; i++) {
            if (fullText.substring(i, i + targetTextLength).equals(target)) {
                count++;
                i += targetTextLength - 1;
            }
        }

        System.out.println(count);
        br.close();
    }
}

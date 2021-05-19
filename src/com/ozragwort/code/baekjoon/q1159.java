package com.ozragwort.code.baekjoon;

import java.io.*;

public class q1159 {
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());
        int[] counter = new int[26];

        for (int i = 0 ; i < N ; i++) {
            char c = br.readLine().charAt(0);
            counter[c - 97]++;
        }

        for (int i = 0 ; i < 26 ; i++) {
            if (counter[i] >= 5) {
                char a = (char) (i + 97);
                sb.append(a);
            }
        }

        if (sb.length() == 0) {
            sb.append("PREDAJA");
        }

        System.out.print(sb);
    }
}

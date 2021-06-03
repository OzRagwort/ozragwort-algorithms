package com.ozragwort.code.baekjoon;

import java.io.*;
import java.util.StringTokenizer;

public class q1474 {
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer stk = new StringTokenizer(br.readLine().trim());
        int N = Integer.parseInt(stk.nextToken());
        int M = Integer.parseInt(stk.nextToken());
        String[] word = new String[N];
        int wordCounter = 0;
        int underBarCounter = 0;
        int maxUnderBarCounter = 0;

        for (int i = 0 ; i < N ; i++) {
            word[i] = br.readLine().trim();
            wordCounter += word[i].length();
        }

        underBarCounter = (M - wordCounter) / (N - 1);
        maxUnderBarCounter = (M - wordCounter) % (N - 1);

        bw.write(word[0]);
        for (int i = 1 ; i < N ; i++) {
            int underBarAdd = 0;
            if ((word[i].charAt(0) >= 97 && maxUnderBarCounter > 0) || (maxUnderBarCounter == N - i)) {
                underBarAdd = 1;
                maxUnderBarCounter--;
            }
            for (int j = 0 ; j < underBarCounter + underBarAdd ; j++) {
                bw.write("_");
            }
            bw.write(word[i]);
        }

        bw.flush();
        bw.close();
        br.close();
    }
}

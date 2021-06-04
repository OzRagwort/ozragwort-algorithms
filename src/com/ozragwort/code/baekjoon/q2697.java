package com.ozragwort.code.baekjoon;

import java.io.*;
import java.util.Arrays;

public class q2697 {
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int T = Integer.parseInt(br.readLine());

        for (int i = 0 ; i < T ; i++) {
            String A = br.readLine().trim();
            bw.write(nextNum(A) + "\n");
        }

        bw.flush();
        bw.close();
        br.close();
    }

    public String nextNum(String A) {
        boolean biggest = true;
        char[] n = new char[A.length()];

        for (int j = 0 ; j < A.length() ; j++) {
            n[j] = A.charAt(j);
        }

        for (int j = A.length() - 1 ; j > 0 ; j--) {
            if (n[j - 1] < n[j]) {
                int next = Integer.MAX_VALUE;
                int nextIndex = 0;
                for (int k = j; k < A.length(); k++) {
                    if (n[j - 1] < n[k] && n[k] < next) {
                        next = n[k];
                        nextIndex = k;
                    }
                }
                char temp = n[j - 1];
                n[j - 1] = n[nextIndex];
                n[nextIndex] = temp;

                Arrays.sort(n, j, A.length());
                biggest = false;
                break;
            }
        }

        if (biggest) {
            return "BIGGEST";
        } else {
            return String.valueOf(n);
        }
    }
}

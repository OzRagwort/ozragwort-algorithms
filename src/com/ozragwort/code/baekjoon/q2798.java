package com.ozragwort.code.baekjoon;

import java.io.*;

public class q2798 {
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String[] S = br.readLine().split(" ");
        String[] numStr = br.readLine().split(" ");
        int[] num = new int[numStr.length];
        for (int i = 0 ; i < numStr.length ; i++) {
            num[i] = Integer.parseInt(numStr[i]);
        }
        int N = Integer.parseInt(S[0]);
        int M = Integer.parseInt(S[1]);
        int a = 0, b = 1, c = 2;
        int sum = 0;

        while(true) {
            int bufSum = num[a] + num[b] +num[c];
            if ((bufSum <= M) && (sum < bufSum)) {
                sum = bufSum;
            }
            if (c < N-1) {
                c++;
            } else if (b != c - 1) {
                b++;
                c = b + 1;
            } else if (a != b - 1) {
                a++;
                b = a + 1;
                c = b + 1;
            } else {
                break;
            }
        }

        bw.write(Integer.toString(sum));
        bw.flush();
        bw.close();
        br.close();
    }
}

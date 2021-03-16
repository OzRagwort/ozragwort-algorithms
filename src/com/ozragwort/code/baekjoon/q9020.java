package com.ozragwort.code.baekjoon;

import java.io.*;

public class q9020 {
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int nMax = 10000;
        boolean[] arr = new boolean[nMax];
        arr[0] = true;

        for (int i = 2 ; i < nMax ; i++) {
            if (!arr[i-1]) {
                int index = i;
                while(index + i <= nMax) {
                    index += i;
                    arr[index - 1] = true;
                }
            }
        }

        int N = Integer.parseInt(br.readLine());
        while(N > 0) {
            int n = Integer.parseInt(br.readLine());
            int gp = 0;
            for (int i = 2 ; i <= n/2 ; i++) {
                if (!arr[i-1] && !arr[n-i-1]) {
                    gp = i;
                }
            }
            bw.write(gp + " " + (n - gp));
            bw.newLine();
            N--;
        }
        bw.flush();
        bw.close();
        br.close();
    }
}

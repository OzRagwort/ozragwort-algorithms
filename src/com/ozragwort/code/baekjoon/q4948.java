package com.ozragwort.code.baekjoon;

import java.io.*;

public class q4948 {
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int nMax = 246912;
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

        int N;
        while((N = Integer.parseInt(br.readLine())) != 0) {
            int counter = 0;
            for (int i = N + 1; i <= N * 2 ; i++) {
                if (!arr[i - 1])
                    counter++;
            }
            bw.write(Integer.toString(counter));
            bw.newLine();
        }
        bw.flush();
        bw.close();
        br.close();
    }
}

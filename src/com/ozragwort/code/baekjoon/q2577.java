package com.ozragwort.code.baekjoon;

import java.io.*;

public class q2577 {

    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int A = Integer.parseInt(br.readLine());
        int B = Integer.parseInt(br.readLine());
        int C = Integer.parseInt(br.readLine());
        int mul = A * B * C;

        int[] count = new int[10];

        while (mul > 0) {
            int n = mul % 10;
            mul /= 10;
            count[n]++;
        }

        for (int i = 0 ; i < 10 ; i++) {
            bw.write(count[i] + "\n");
        }

        bw.flush();
        bw.close();
        br.close();
    }

}

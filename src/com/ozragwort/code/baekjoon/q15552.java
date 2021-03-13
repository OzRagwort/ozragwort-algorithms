package com.ozragwort.code.baekjoon;

import java.io.*;

public class q15552 {
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String result = "";
        int N = Integer.parseInt(br.readLine());

        for(int i = 0 ; i < N ; i++) {
            String[] num = br.readLine().split(" ");
            result = Integer.toString(Integer.parseInt(num[0]) + Integer.parseInt(num[1]));
            bw.write(result);
            bw.newLine();
        }

        bw.flush();
        bw.close();
        br.close();
    }
}

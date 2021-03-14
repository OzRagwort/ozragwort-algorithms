package com.ozragwort.code.baekjoon;

import java.io.*;

public class q8958 {
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        for (int i = 0 ; i < N ; i++) {
            String value = br.readLine();
            int result = 0;
            int counter = 0;
            for (int j = 0 ; j < value.length() ; j++) {
                if (value.charAt(j) == 'O') {
                    counter++;
                    result += counter;
                } else {
                    counter = 0;
                }
            }
            bw.write(Integer.toString(result));
            bw.newLine();
        }

        bw.flush();
        bw.close();
        br.close();
    }
}

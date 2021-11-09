package com.ozragwort.code.baekjoon;

import java.io.*;

public class q15886 {

    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        String ew = br.readLine();

        int count = 0;
        for (int i = 0 ; i < N - 1 ; i++) {
            String il = ew.substring(i, i + 2);

            if (il.equals("EW")) {
                count++;
                i++;
            }
        }

        System.out.println(count);

        br.close();
    }

}

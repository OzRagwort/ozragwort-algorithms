package com.ozragwort.code.baekjoon;

import java.io.*;

public class q1316 {
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());
        int counter = 0;

        for (int i = 0 ; i < N ; i++) {
            String str = br.readLine();
            char b = ' ';
            String buffer = "";
            for (int j = 0 ; j < str.length() ; j++) {
                if (b != str.charAt(j) && buffer.contains(String.valueOf(str.charAt(j))))
                    break;
                else {
                    if (b != str.charAt(j)) {
                        b = str.charAt(j);
                    }
                    buffer += String.valueOf(str.charAt(j));
                }
                if (j == str.length() - 1)
                    counter++;
            }
        }

        bw.write(Integer.toString(counter));

        bw.flush();
        bw.close();
        br.close();
    }
}

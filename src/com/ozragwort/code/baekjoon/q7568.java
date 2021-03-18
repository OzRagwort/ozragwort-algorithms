package com.ozragwort.code.baekjoon;

import java.io.*;

public class q7568 {
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());
        String[][] people = new String[N][2];
        for (int i = 0 ; i < N ; i++) {
            people[i] = br.readLine().split(" ");
        }
        for (int i = 0 ; i < N ; i++) {
            int rank = 1;
            for (int j = 0 ; j < N ; j++) {
                if ((Integer.parseInt(people[i][0]) < Integer.parseInt(people[j][0])) && (Integer.parseInt(people[i][1]) < Integer.parseInt(people[j][1]))) {
                    rank++;
                }
            }
            bw.write(rank + " ");
        }

        bw.flush();
        bw.close();
        br.close();
    }
}

package com.ozragwort.code.baekjoon;

import java.io.*;

public class q1003 {

    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());

        int[][] counter = new int[41][2];
        counter[0] = new int[]{1, 0};
        counter[1] = new int[]{0, 1};
        for (int i = 2 ; i < 41 ; i++) {
            counter[i] = func(i, counter);
        }

        for (int i = 0 ; i < N ; i++) {
            int num = Integer.parseInt(br.readLine());
            bw.write(counter[num][0] + " " + counter[num][1] + "\n");
        }

        bw.flush();
        bw.close();
        br.close();
    }

    public int[] func(int num, int[][] counter) {
        int[] arr = new int[2];
        arr[0] = counter[num - 1][0] + counter[num - 2][0];
        arr[1] = counter[num - 1][1] + counter[num - 2][1];

        return arr;
    }

}

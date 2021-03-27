package com.ozragwort.code.baekjoon;

import java.io.*;
import java.util.*;

public class q10814 {
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());
        String[][] arr = new String[N][2];
        StringTokenizer stk;

        for (int i = 0 ; i < N ; i++) {
            stk = new StringTokenizer(br.readLine());
            arr[i][0] = stk.nextToken();
            arr[i][1] = stk.nextToken();
        }

        Arrays.sort(arr, new Comparator<String[]>() {
            public int compare(String[] s1, String[] s2) {
                return Integer.parseInt(s1[0]) - Integer.parseInt(s2[0]);
            }
        });

        for (String[] s : arr) {
            bw.write(s[0] + " " + s[1] + "\n");
        }

        bw.flush();
        bw.close();
        br.close();
    }
}

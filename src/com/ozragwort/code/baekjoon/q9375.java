package com.ozragwort.code.baekjoon;

import java.io.*;
import java.util.*;

public class q9375 {
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());

        for (int i = 0 ; i < N ; i++) {
            int n = Integer.parseInt(br.readLine());
            HashMap<String, Integer> map = new HashMap<>();
            for (int j = 0 ; j < n ; j++) {
                String[] dress = br.readLine().split(" ");
                if (map.containsKey(dress[1])) {
                    map.put(dress[1], map.get(dress[1]) + 1);
                } else {
                    map.put(dress[1], 1);
                }
            }

            int counter = 1;
            for (String name : map.keySet()) {
                counter *= map.get(name) + 1;
            }
            bw.write(counter - 1 + "\n");
        }

        bw.flush();
        bw.close();
        br.close();
    }
}

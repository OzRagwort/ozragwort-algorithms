package com.ozragwort.code.baekjoon;

import java.io.*;
import java.util.*;

public class q20291 {

    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        TreeMap<String, Integer> treeMap = new TreeMap<>();

        for (int i = 0 ; i < N ; i++) {
            String extension = br.readLine().split("\\.")[1];
            if (treeMap.containsKey(extension)) {
                treeMap.put(extension, treeMap.get(extension) + 1);
            } else {
                treeMap.put(extension, 1);
            }
        }

        for (String key : treeMap.keySet()) {
            bw.write(key + " " + treeMap.get(key) + "\n");
        }

        bw.flush();
        bw.close();
        br.close();
    }

}

package com.ozragwort.code.baekjoon;

import java.io.*;
import java.util.*;

public class q1181 {
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());
        HashSet<String> setData = new HashSet<String>();
        List<String> list;

        for (int i = 0 ; i < N ; i++) {
            setData.add(br.readLine());
        }

        list = new ArrayList<>(setData);

        Collections.sort(list, new Comparator<String>() {
            public int compare(String s1, String s2) {
                if (s1.length() == s2.length()) {
                    return s1.compareTo(s2);
                } else {
                    return s1.length() - s2.length();
                }
            }
        });

        for (String s : list) {
            bw.write(s + "\n");
        }

        bw.flush();
        bw.close();
        br.close();
    }
}

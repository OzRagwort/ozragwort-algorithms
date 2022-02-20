package com.ozragwort.code.baekjoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;

public class q2204 {

    static class DobiSort {

        public String getFirst(List<String> texts) {
            texts.sort((o1, o2) -> {
                String s1 = o1.toLowerCase();
                String s2 = o2.toLowerCase();
                if (s1.compareTo(s2) == 0) {
                    return o1.compareTo(o2);
                }
                return s1.compareTo(s2);
            });
            return texts.get(0);
        }
    }

    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        DobiSort dobiSort = new DobiSort();
        String input = null;
        while (!(input = br.readLine()).equals("0")) {
            List<String> texts = new ArrayList<>();
            for (int i = 0; i < Integer.parseInt(input); i++) {
                texts.add(br.readLine());
            }
            bw.write(dobiSort.getFirst(texts));
            bw.newLine();
        }

        bw.flush();
        bw.close();
        br.close();
    }
}

package com.ozragwort.code.baekjoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class q2217 {
    static class Rope {
        private final Integer length;

        public Rope(Integer length) {
            this.length = length;
        }

        public Integer getLength() {
            return this.length;
        }
    }

    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        List<Rope> ropes = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            StringTokenizer stk = new StringTokenizer(br.readLine());
            Rope rope = new Rope(Integer.parseInt(stk.nextToken()));
            ropes.add(rope);
        }

        ropes.sort((o1, o2) -> o2.getLength() - o1.getLength());

        int maxWeight = 0;
        for (int ropeCount = 1; ropeCount <= ropes.size(); ropeCount++) {
            int weight = ropeCount * ropes.get(ropeCount - 1).getLength();
            if (maxWeight < weight) {
                maxWeight = weight;
            }
        }

        bw.write(String.valueOf(maxWeight));

        bw.flush();
        bw.close();
        br.close();
    }
}

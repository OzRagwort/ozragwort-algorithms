package com.ozragwort.code.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class q2785 {

    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        StringTokenizer stk = new StringTokenizer(br.readLine());
        List<Integer> counts = new ArrayList<>();
        for (int i = 0 ; i < N ; i++) {
            counts.add(Integer.parseInt(stk.nextToken()));
        }
        System.out.println(calculateMinRingCount(counts));

        br.close();
    }

    public int calculateMinRingCount(List<Integer> ringCount) {
        Collections.sort(ringCount);
        int count = 0;
        int restRing = ringCount.size();
        for (int i = 0; restRing > 0; i++) {
            if (ringCount.get(i) >= restRing - 1) {
                count += restRing - 1;
                break;
            }
            restRing -= ringCount.get(i) + 1;
            count += ringCount.get(i);
        }
        return count;
    }
}

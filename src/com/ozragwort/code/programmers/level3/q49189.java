package com.ozragwort.code.programmers.level3;

import java.util.*;

public class q49189 {
    public int solution(int n, int[][] edge) {
        Queue<Integer> edges = new LinkedList<>();
        Queue<Integer> counter = new LinkedList<>();
        HashMap<Integer, List<Integer>> map = new HashMap<>();
        boolean[] visit = new boolean[n + 1];
        int max = 0, maxCounter = 0;

        // make map
        for (int[] e : edge) {
            if (!map.containsKey(e[0])) map.put(e[0], new ArrayList<>());
            if (!map.containsKey(e[1])) map.put(e[1], new ArrayList<>());

            map.get(e[0]).add(e[1]);
            map.get(e[1]).add(e[0]);
        }

        // init
        visit[1] = true;
        edges.offer(1);
        counter.offer(0);

        // search
        while (!edges.isEmpty() && !counter.isEmpty()) {
            // dist check
            int count = counter.poll();
            if (max < count) {
                max = count;
                maxCounter = 1;
            } else {
                maxCounter++;
            }

            // next node check
            List<Integer> list = map.get(edges.poll());
            for (int l : list) {
                if (visit[l]) {
                    continue;
                } else {
                    visit[l] = true;
                    edges.offer(l);
                    counter.offer(count + 1);
                }
            }
        }

        return maxCounter;
    }
}

package com.ozragwort.code.baekjoon;

import java.io.*;
import java.util.HashMap;
import java.util.HashSet;
import java.util.StringTokenizer;

public class q1595 {

    HashMap<Long, HashMap<Long, Long>> nodes = new HashMap<>();
    HashSet<Long> visit = new HashSet<>();
    long farIndex = 0;
    long maxCost = 0;

    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String input = "";
        long ivIndex = 0;
        while ((input = br.readLine()) != null) {
            StringTokenizer stk = new StringTokenizer(input.trim());

            if (stk.countTokens() < 3) continue;

            long a = Long.parseLong(stk.nextToken());
            long b = Long.parseLong(stk.nextToken());
            long v = Long.parseLong(stk.nextToken());

            if (!nodes.containsKey(a)) {
                nodes.put(a, new HashMap<>());
            }
            if (!nodes.containsKey(b)) {
                nodes.put(b, new HashMap<>());
            }

            nodes.get(a).put(b, v);
            nodes.get(b).put(a, v);
            ivIndex = a;
        }

        if (nodes.isEmpty()) {
            maxCost = 0;
        } else {
            dfs(ivIndex, 0);
            visit.clear();
            dfs(farIndex, 0);
        }

        System.out.println(maxCost);
    }

    public void dfs(long n, long cost) {
        visit.add(n);

        if (maxCost < cost) {
            maxCost = cost;
            farIndex = n;
        }

        for (long nextNodeIndex : nodes.get(n).keySet()) {
            if (visit.contains(nextNodeIndex)) {
                continue;
            } else {
                dfs(nextNodeIndex, cost + nodes.get(n).get(nextNodeIndex));
            }
        }
    }
}

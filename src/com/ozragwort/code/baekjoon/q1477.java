package com.ozragwort.code.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class q1477 {

    static class DistInfo {
        private int dist;
        private int count;

        DistInfo(int dist) {
            this.dist = dist;
            count = 0;
        }

        public int maxDivDist() {
            int weight = dist % (count + 1) == 0 ? 0 : 1;
            return dist / (count + 1) + weight;
        }

        public void increaseCount() {
            count++;
        }
    }

    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer stk = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(stk.nextToken());
        int M = Integer.parseInt(stk.nextToken());
        int L = Integer.parseInt(stk.nextToken());

        stk = new StringTokenizer(br.readLine().trim());
        List<Integer> positions = new ArrayList<>();
        positions.add(0);
        positions.add(L);
        while (stk.hasMoreTokens()) {
            positions.add(Integer.parseInt(stk.nextToken()));
        }
        positions.sort(Comparator.comparingInt(o -> o));

        List<DistInfo> distInfos = new ArrayList<>();
        for (int i = 0; i < positions.size() - 1; i++) {
            distInfos.add(new DistInfo(positions.get(i + 1) - positions.get(i)));
        }

        PriorityQueue<DistInfo> pq = new PriorityQueue<>((o1, o2) -> o2.maxDivDist() - o1.maxDivDist());
        pq.addAll(distInfos);

        for (int i = 0; i < M; i++) {
            DistInfo distInfo = pq.poll();
            distInfo.increaseCount();
            pq.offer(distInfo);
        }

        System.out.println(pq.poll().maxDivDist());
    }

}

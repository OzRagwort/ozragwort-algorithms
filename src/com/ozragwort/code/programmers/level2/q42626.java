package com.ozragwort.code.programmers.level2;

import java.util.PriorityQueue;

public class q42626 {
    public int solution(int[] scoville, int K) {
        int answer = 0;

        PriorityQueue<Integer> pq = new PriorityQueue<>();

        for (int s : scoville) {
            pq.offer(s);
        }

        while (pq.size() >= 2 && pq.peek() < K) {
            int a = pq.poll();
            int b = pq.poll();
            pq.offer(a + (b * 2));
            answer++;
        }

        if (!pq.isEmpty() && pq.peek() >= K) {
            return answer;
        } else {
            return -1;
        }
    }
}

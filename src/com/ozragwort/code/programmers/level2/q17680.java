package com.ozragwort.code.programmers.level2;

import java.util.LinkedList;
import java.util.Locale;
import java.util.Queue;

public class q17680 {
    public int solution(int cacheSize, String[] cities) {
        Queue<String> queue = new LinkedList<>();
        int time = 0;

        for (String city : cities) {
            city = city.toLowerCase(Locale.ROOT);

            if (queue.contains(city)) {
                time++;
                queue.remove(city);
            } else if (queue.size() >= cacheSize) {
                time += 5;
                queue.poll();
            } else {
                time += 5;
            }

            if (queue.size() + 1 <= cacheSize) {
                queue.offer(city);
            }
        }

        return time;
    }
}

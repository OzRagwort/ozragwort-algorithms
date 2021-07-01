package com.ozragwort.code.programmers.level2;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class q42587 {
    Queue<Integer> queue = new LinkedList<>();

    public int solution(int[] priorities, int location) {
        int answer = 0;
        int sortIndex = priorities.length - 1;

        for (int p : priorities) {
            queue.offer(p);
        }

        Arrays.sort(priorities);

        while (!queue.isEmpty()) {
            if (queue.peek() == priorities[sortIndex]) {
                if (location == 0) {
                    answer++;
                    break;
                } else {
                    sortIndex--;
                    location = subLocation(location, queue.size());
                }
                queue.poll();
                answer++;
            } else {
                queue.offer(queue.poll());
                location = subLocation(location, queue.size());
            }
        }

        return answer;
    }

    public int subLocation(int location, int size) {
        location--;
        if (location < 0) {
            location += size;
        }
        return location;
    }
}

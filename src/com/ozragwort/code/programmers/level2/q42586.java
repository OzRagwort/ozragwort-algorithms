package com.ozragwort.code.programmers.level2;

import java.util.Iterator;
import java.util.TreeMap;

public class q42586 {
    public int[] solution(int[] progresses, int[] speeds) {
        int[] answer = {};
        int day = 1;
        TreeMap<Integer, Integer> treeMap = new TreeMap<>();

        for (int i = 0 ; i < progresses.length ; i++) {
            while (progresses[i] + (speeds[i] * day) < 100) {
                day++;
            }
            if (treeMap.containsKey(day)) {
                treeMap.put(day, treeMap.get(day) + 1);
            } else {
                treeMap.put(day, 1);
            }
        }

        answer = new int[treeMap.size()];
        Iterator<Integer> iterator = treeMap.keySet().iterator();
        for (int i = 0 ; i < treeMap.size() ; i++) {
            answer[i] = treeMap.get(iterator.next());
        }

        return answer;
    }
}

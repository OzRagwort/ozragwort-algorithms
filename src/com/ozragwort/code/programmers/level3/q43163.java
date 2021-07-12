package com.ozragwort.code.programmers.level3;

import java.util.HashMap;
import java.util.Queue;
import java.util.LinkedList;

public class q43163 {
    public int solution(String begin, String target, String[] words) {
        HashMap<String, Integer> map = new HashMap<>();
        Queue<String> queue = new LinkedList<>();

        queue.offer(begin);
        map.put(begin, 0);

        while (!queue.isEmpty()) {
            String str = queue.poll();
            for (String word : words) {
                if (!map.containsKey(word) && compareNext(str, word)) {
                    int counter = map.get(str) + 1;
                    if (word.equals(target)) {
                        return counter;
                    }
                    map.put(word, counter);
                    queue.offer(word);
                }
            }
        }

        return 0;
    }

    public boolean compareNext(String a, String b) {
        int diffCounter = 0;
        for (int i = 0 ; i < a.length() ; i++) {
            if (a.charAt(i) != b.charAt(i)) {
                diffCounter++;
            }
        }
        return diffCounter == 1;
    }
}

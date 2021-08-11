package com.ozragwort.code.programmers.level3;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.TreeSet;

public class q67258 {
    public int[] solution(String[] gems) {
        HashSet<String> gemSet = new HashSet<>(Arrays.asList(gems));
        HashMap<String, Integer> indexing = new HashMap<>();
        TreeSet<Integer> sort = new TreeSet<>();
        int[] answer = new int[2];
        int min = 1000000;
        int max = 0;
        int length = Integer.MAX_VALUE;

        for (int i = 0 ; i < gems.length ; i++) {
            if (indexing.containsKey(gems[i])) {
                int index = indexing.get(gems[i]);
                sort.remove(index);
            }
            sort.add(i);
            max = i;
            min = sort.first();

            indexing.put(gems[i], i);

            if (indexing.size() == gemSet.size() && max - min < length) {
                answer[0] = min + 1;
                answer[1] = max + 1;
                length = max - min;
            }
        }

        return answer;
    }
}

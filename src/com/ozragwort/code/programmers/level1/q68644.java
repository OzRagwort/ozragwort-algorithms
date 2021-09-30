package com.ozragwort.code.programmers.level1;

import java.util.TreeSet;

public class q68644 {
    public int[] solution(int[] numbers) {
        TreeSet<Integer> set = new TreeSet<>((o1, o2) -> o1 - o2);

        for (int i = 0 ; i < numbers.length - 1 ; i++) {
            for (int j = i + 1 ; j < numbers.length ; j++) {
                set.add(numbers[i] + numbers[j]);
            }
        }

        int[] answer = set.stream().mapToInt(Integer::intValue).toArray();
        return answer;
    }
}

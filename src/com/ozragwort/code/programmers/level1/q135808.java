package com.ozragwort.code.programmers.level1;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class q135808 {
    public int solution(int k, int m, int[] score) {
        List<Integer> scores = Arrays.stream(score)
                .boxed()
                .sorted((o1, o2) -> o2 - o1)
                .collect(Collectors.toList());

        int answer = 0;
        for (int i = 1; i * m <= score.length; i++) {
            answer += Math.min(k, scores.get(i * m - 1)) * m;
        }
        return answer;
    }
}

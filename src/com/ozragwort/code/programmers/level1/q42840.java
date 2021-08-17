package com.ozragwort.code.programmers.level1;

import java.util.ArrayList;
import java.util.List;

public class q42840 {
    public int[] solution(int[] answers) {
        int[][] rule = new int[][]{{}, {1,2,3,4,5}, {2,1,2,3,2,4,2,5}, {3,3,1,1,2,2,4,4,5,5}};
        int[] answer = new int[answers.length + 1];
        int max = 0;

        for (int i = 0 ; i < answers.length ; i++) {
            for (int j = 1 ; j <= 3 ; j++) {
                if (rule[j][i % rule[j].length] == answers[i]) {
                    answer[j]++;
                    if (max < answer[j]) {
                        max = answer[j];
                    }
                }
            }
        }

        List<Integer> list = new ArrayList<>();
        for (int i = 1 ; i <= answers.length ; i++) {
            if (max == answer[i]) {
                list.add(i);
            }
        }

        return list.stream().mapToInt(Integer::intValue).toArray();
    }
}

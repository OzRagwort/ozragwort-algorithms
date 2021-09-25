package com.ozragwort.code.programmers.level2;

import java.util.ArrayList;
import java.util.List;

public class q86048 {
    public int[] solution(int[] enter, int[] leave) {
        int[] answer = new int[leave.length];
        List<Integer> list = new ArrayList<>();

        int ei = 0;
        int li = 0;
        while (li < leave.length) {
            if (list.contains(leave[li])) {
                for (Integer i : list) {
                    if (leave[li] != i) {
                        answer[i - 1]++;
                        answer[leave[li] - 1]++;
                    }
                }

                list.remove((Integer) leave[li]);
                li++;
            } else {
                if (ei < enter.length) {
                    list.add(enter[ei]);
                    ei++;
                }
            }
        }

        return answer;
    }
}

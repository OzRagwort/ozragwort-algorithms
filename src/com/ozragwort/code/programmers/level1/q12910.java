package com.ozragwort.code.programmers.level1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class q12910 {
    public int[] solution(int[] arr, int divisor) {
        int[] answer = {};
        List<Integer> list = new ArrayList<>();

        for (int n : arr) {
            if (n % divisor == 0) {
                list.add(n);
            }
        }

        if (list.size() == 0) {
            return new int[]{-1};
        } else {
            answer = new int[list.size()];
            for (int i = 0 ; i < list.size() ; i++) {
                answer[i] = list.get(i);
            }
            Arrays.sort(answer);

            return answer;
        }
    }
}

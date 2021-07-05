package com.ozragwort.code.programmers.level2;

import java.util.Arrays;

public class q42747 {
    public int solution(int[] citations) {
        Arrays.sort(citations);

        int answer = 0;

        for (int i = 0 ; i <= citations.length ; i++) {
            for (int j = 0 ; j < citations.length ; j++) {
                if (citations[j] >= i) {
                    if (citations.length - j >= i && j <= i) {
                        answer = i;
                    }
                    break;
                }
            }
        }

        return answer;
    }
}

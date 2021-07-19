package com.ozragwort.code.programmers.level3;

import java.util.Arrays;

public class q12927 {
    public long solution(int n, int[] works) {
        long sum = 0;
        for (int work : works) {
            sum += work;
        }
        sum -= n;

        if (sum > 0) {
            Arrays.sort(works);

            for (int i = 0 ; i < works.length ; i++) {
                int num = (int) (sum / (works.length - i));
                if (works[i] >= num) {
                    works[i] = num;
                }
                sum -= works[i];
            }

            long answer = 0;
            for (int work : works) {
                answer += Math.pow(work, 2);
            }
            return answer;
        } else {
            return 0;
        }
    }
}

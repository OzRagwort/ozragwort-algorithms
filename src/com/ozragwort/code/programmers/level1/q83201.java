package com.ozragwort.code.programmers.level1;

import java.util.Arrays;

public class q83201 {
    public String solution(int[][] scores) {
        StringBuilder answer = new StringBuilder();
        int[] sum = new int[scores.length];
        int[] size = new int[scores.length];

        Arrays.fill(size, scores.length);

        for (int p = 0 ; p < scores[0].length ; p++) {
            int self = scores[p][p];
            int max = self;
            int min = self;
            boolean check = true;

            for (int j = 0 ; j < scores.length ; j++) {
                if (p != j) {
                    sum[p] += scores[j][p];

                    if (self == scores[j][p]) {
                        check = false;
                    }
                    if (max < scores[j][p]) {
                        max = scores[j][p];
                    }
                    if (min > scores[j][p]) {
                        min = scores[j][p];
                    }
                }
            }

            if (check && (max == self || min == self)) {
                size[p] = scores.length - 1;
            } else {
                sum[p] += self;
            }
        }

        for (int i = 0 ; i < sum.length ; i++) {
            answer.append(grade(sum[i] / size[i]));
        }

        return answer.toString();
    }

    public String grade(int score) {
        if (score >= 90) {
            return "A";
        } else if (score >= 80) {
            return "B";
        } else if (score >= 70) {
            return "C";
        } else if (score >= 50) {
            return "D";
        } else {
            return "F";
        }
    }
}

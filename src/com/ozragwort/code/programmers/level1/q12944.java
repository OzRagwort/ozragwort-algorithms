package com.ozragwort.code.programmers.level1;

public class q12944 {
    public double solution(int[] arr) {
        int sum = 0;

        for (int i : arr) {
            sum += i;
        }

        double answer = (double) sum / arr.length;
        return answer;
    }
}

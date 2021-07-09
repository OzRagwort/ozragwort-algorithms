package com.ozragwort.code.programmers.level3;

public class q43238 {
    public long solution(int n, int[] times) {
        long left = 0;
        long right = 1000000000000000000L;
        long mid = (left + right) / 2;
        long sum = 0;

        while (left < right) {
            sum = 0;
            for (int time : times) {
                sum += mid / time;
            }
            if (n <= sum) {
                right = mid;
                mid = (left + right) / 2;
            } else {
                left = mid + 1;
                mid = (left + right) / 2;
            }
        }

        return mid;
    }
}

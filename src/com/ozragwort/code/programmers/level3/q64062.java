package com.ozragwort.code.programmers.level3;

public class q64062 {
    public int solution(int[] stones, int k) {
        int left = 0;
        int right = 200000000;
        int mid = (left + right) / 2;

        while (left < right) {
            boolean check = check(stones, mid, k);
            if (check) {
                left = mid + 1;
                mid = (left + right) / 2;
            } else {
                right = mid;
                mid = (left + right) / 2;
            }
        }

        return mid;
    }

    public boolean check(int[] stones, int mid, int k) {
        int len = 0;

        for (int i = 0 ; i < stones.length ; i++) {
            if (stones[i] <= mid) {
                len++;
            } else {
                len = 0;
            }
            if (len == k) {
                return false;
            }
        }

        return true;
    }
}

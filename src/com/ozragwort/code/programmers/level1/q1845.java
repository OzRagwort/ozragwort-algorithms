package com.ozragwort.code.programmers.level1;

import java.util.HashSet;

public class q1845 {
    public int solution(int[] nums) {
        int answer = 0;

        HashSet<Integer> hashSet = new HashSet<>();

        for (int n : nums) {
            hashSet.add(n);
        }

        if (nums.length / 2 < hashSet.size()) {
            answer = nums.length / 2;
        } else {
            answer = hashSet.size();
        }

        return answer;
    }
}

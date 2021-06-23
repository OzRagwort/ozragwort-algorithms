package com.ozragwort.code.programmers.level1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class q12977 {
    public int solution(int[] nums) {
        int answer = -1;
        int max = 0;
        boolean[] primeNum;
        List<Integer> list = new ArrayList<>();

        for (int i = 0 ; i < nums.length - 2 ; i++) {
            for (int j = i + 1 ; j < nums.length - 1 ; j++) {
                for (int k = j + 1 ; k < nums.length ; k++) {
                    list.add(nums[i] + nums[j] + nums[k]);
                    if (max < nums[i] + nums[j] + nums[k]) {
                        max = nums[i] + nums[j] + nums[k];
                    }
                }
            }
        }

        primeNum = new boolean[max + 1];
        Arrays.fill(primeNum, true);
        for (int i = 2 ; i * i <= max ; i++) {
            if (primeNum[i]) {
                for (int j = i + i ; j < max + 1 ; j+=i) {
                    if (primeNum[j]) {
                        primeNum[j] = false;
                    }
                }
            }
        }

        answer = 0;
        for (int n : list) {
            if (primeNum[n]) {
                answer++;
            }
        }

        return answer;
    }
}

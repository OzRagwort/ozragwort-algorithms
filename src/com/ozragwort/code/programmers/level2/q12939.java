package com.ozragwort.code.programmers.level2;

import java.util.Arrays;

public class q12939 {
    public String solution(String s) {
        int[] nums = Arrays.stream(s.split(" ")).mapToInt(Integer::parseInt).toArray();
        Arrays.sort(nums);
        String answer = nums[0] + " " + nums[nums.length - 1];
        return answer;
    }
}

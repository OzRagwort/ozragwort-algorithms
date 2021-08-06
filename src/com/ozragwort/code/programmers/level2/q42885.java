package com.ozragwort.code.programmers.level2;

import java.util.Arrays;

public class q42885 {
    public int solution(int[] people, int limit) {
        int answer = 0;
        int left = 0;
        int right = people.length - 1;
        int sum = 0;

        Arrays.sort(people);

        while (left <= right) {
            sum = people[right];
            right--;
            if (left <= right && sum + people[left] <= limit) {
                left++;
            }
            answer++;
        }

        return answer;
    }
}

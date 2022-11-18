package com.ozragwort.code.programmers.level1;

public class q136798 {
    public int solution(int number, int limit, int power) {
        int[] counter = new int[number + 1];
        for (int i = 1; i <= number; i++) {
            for (int c = i; c <= number; c += i) {
                counter[c]++;
            }
        }

        int answer = 0;
        for (int count : counter) {
            if (count > limit) {
                answer += power;
            } else {
                answer += count;
            }
        }
        return answer;
    }
}

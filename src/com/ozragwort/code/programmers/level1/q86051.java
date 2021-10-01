package com.ozragwort.code.programmers.level1;

public class q86051 {
    public int solution(int[] numbers) {
        int answer = 45;

        for (int number : numbers) {
            answer -= number;
        }

        return answer;
    }
}

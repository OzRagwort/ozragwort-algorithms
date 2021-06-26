package com.ozragwort.code.programmers.level2;

public class q43165 {
    public int solution(int[] numbers, int target) {
        int answer = 0;

        answer = dfs(numbers, target, 0, 0);

        return answer;
    }

    public int dfs(int[] numbers, int target, int i, int value) {
        int result = 0;

        if (i == numbers.length) {
            if (target == value) {
                result += 1;
            }
        } else {
            result += dfs(numbers, target, i + 1, value + numbers[i]);
            result += dfs(numbers, target, i + 1, value - numbers[i]);
        }

        return result;
    }
}

package com.ozragwort.code.programmers.level1;

import java.util.Stack;

public class q12906 {
    public int[] solution(int []arr) {
        Stack<Integer> stack = new Stack<>();

        for (int i : arr) {
            if (stack.isEmpty() || stack.peek() != i) {
                stack.push(i);
            }
        }

        int[] answer = stack.stream().mapToInt(Integer::intValue).toArray();
        return answer;
    }
}

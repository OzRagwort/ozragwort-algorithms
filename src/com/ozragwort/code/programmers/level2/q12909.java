package com.ozragwort.code.programmers.level2;

import java.util.Stack;

public class q12909 {
    boolean solution(String s) {
        Stack<Character> stack = new Stack<>();

        for (int i = 0 ; i < s.length() ; i++) {
            char c = s.charAt(i);

            if (c == '(') {
                stack.push(c);
            } else {
                if (!stack.isEmpty() && stack.peek() == '(') {
                    stack.pop();
                } else {
                    return false;
                }
            }
        }

        return stack.isEmpty();
    }
}

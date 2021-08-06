package com.ozragwort.code.programmers.level2;

import java.util.HashMap;
import java.util.Stack;

public class q76502 {
    Stack<Character> stack;
    HashMap<Character, Character> hashMap;
    String s;

    public int solution(String s) {
        stack = new Stack<>();
        hashMap = new HashMap<>();
        this.s = s;
        int answer = 0;

        hashMap.put('(', ')');
        hashMap.put('{', '}');
        hashMap.put('[', ']');

        for (int i = 0 ; i < s.length() ; i++) {
            if (check(i)) {
                answer++;
                stack.clear();
            }
        }

        return answer;
    }

    public boolean check(int startIndex) {
        for (int i = 0 ; i < s.length() ; i++) {
            int index = (startIndex + i) % s.length();
            char c = s.charAt(index);

            if (hashMap.containsKey(c)) {
                stack.push(c);
            } else {
                if (stack.isEmpty()) {
                    return false;
                } else {
                    char p = stack.pop();
                    if (hashMap.get(p) != c) {
                        return false;
                    }
                }
            }
        }
        return stack.isEmpty();
    }
}

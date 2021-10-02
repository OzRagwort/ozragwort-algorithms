package com.ozragwort.code.programmers.level1;

public class q12916 {
    boolean solution(String s) {
        int count = 0;

        s = s.toLowerCase();
        s = s.replaceAll("[^py]", "");

        for (int i = 0 ; i < s.length() ; i++) {
            char c = s.charAt(i);
            if (c == 'p') {
                count++;
            } else if (c == 'y') {
                count--;
            }
        }

        boolean answer = count == 0;
        return answer;
    }
}

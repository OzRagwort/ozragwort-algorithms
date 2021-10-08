package com.ozragwort.code.programmers.level1;

public class q12918 {
    public boolean solution(String s) {
        boolean answer = true;

        try {
            Integer.parseInt(s, 10);
            if (s.length() != 4 && s.length() != 6) {
                throw new Exception();
            }
        } catch (Exception e) {
            answer = false;
        }

        return answer;
    }
}

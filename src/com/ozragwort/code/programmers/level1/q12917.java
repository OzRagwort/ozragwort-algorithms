package com.ozragwort.code.programmers.level1;

import java.util.Arrays;

public class q12917 {
    public String solution(String s) {
        char[] arr = s.toCharArray();
        Arrays.sort(arr);

        String answer = new StringBuilder(new String(arr)).reverse().toString();
        return answer;
    }
}

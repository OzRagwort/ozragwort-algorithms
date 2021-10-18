package com.ozragwort.code.programmers.level1;

import java.util.Arrays;

public class q12933 {
    public long solution(long n) {
        byte[] bytes = Long.toString(n).getBytes();
        Arrays.sort(bytes);
        String s = new StringBuilder(new String(bytes)).reverse().toString();

        long answer = Long.parseLong(s);
        return answer;
    }
}

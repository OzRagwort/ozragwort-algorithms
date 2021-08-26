package com.ozragwort.code.programmers.level1;

public class q12903 {
    public String solution(String s) {
        int oe = s.length() % 2;
        int len = 2 - oe;
        int start = s.length() / 2 + oe - 1;
        return s.substring(start, start + len);
    }
}

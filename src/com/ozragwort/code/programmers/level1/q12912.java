package com.ozragwort.code.programmers.level1;

public class q12912 {
    public long solution(int a, int b) {
        long answer = ((long) Math.abs(a - b) + 1) * (a + b) / 2;
        return answer;
    }
}

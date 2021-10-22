package com.ozragwort.code.programmers.level1;

public class q12934 {
    public long solution(long n) {
        long answer = -1;

        double s = Math.sqrt(n);
        if (s % 1 == 0) {
            s++;
            answer = (long) (s * s);
        }

        return answer;
    }
}

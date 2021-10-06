package com.ozragwort.code.programmers.level1;

public class q70128 {
    public int solution(int[] a, int[] b) {
        int answer = 0;

        for (int i = 0 ; i < a.length ; i++) {
            answer += a[i] * b[i];
        }

        return answer;
    }
}

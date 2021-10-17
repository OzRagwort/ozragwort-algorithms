package com.ozragwort.code.programmers.level1;

public class q77884 {
    public int solution(int left, int right) {
        int answer = 0;

        for (int i = left ; i <= right ; i++) {
            int s = (int) Math.sqrt(i);
            if (s * s == i) {
                answer -= i;
            } else {
                answer += i;
            }
        }

        return answer;
    }
}

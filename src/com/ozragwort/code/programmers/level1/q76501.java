package com.ozragwort.code.programmers.level1;

public class q76501 {
    public int solution(int[] absolutes, boolean[] signs) {
        int answer = 0;
        for (int i = 0 ; i < absolutes.length ; i++) {
            if (signs[i]) {
                answer += absolutes[i];
            } else {
                answer -= absolutes[i];
            }
        }
        return answer;
    }
}

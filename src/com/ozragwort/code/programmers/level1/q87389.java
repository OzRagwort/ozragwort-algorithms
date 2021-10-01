package com.ozragwort.code.programmers.level1;

public class q87389 {
    public int solution(int n) {
        n -= 1;
        int answer = n;

        for (int i = 2 ; i * i <= n ; i++) {
            if (n % i == 0) {
                answer = i;
                break;
            }
        }

        return answer;
    }
}

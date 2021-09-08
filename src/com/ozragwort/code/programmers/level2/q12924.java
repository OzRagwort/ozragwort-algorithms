package com.ozragwort.code.programmers.level2;

public class q12924 {
    public int solution(int n) {
        int answer = 0;
        int quotient = 0;
        int remainder = 0;

        for (int i = 1 ; i <= n ; i++) {
            quotient = n / i;
            remainder = n % i;

            if (quotient - (i - 1) / 2 > 0) {
                if (i % 2 == 0) {
                    if (remainder == i / 2) {
                        answer++;
                    }
                } else {
                    if (remainder == 0) {
                        answer++;
                    }
                }
            }
        }

        return answer;
    }
}

package com.ozragwort.code.programmers.level1;

public class q12943 {
    public int solution(int num) {
        int answer = 0;

        long n = num;
        while (true) {
            if (n == 1) {
                break;
            }
            if (answer > 500) {
                answer = -1;
                break;
            }

            answer++;
            if (n % 2 == 0) {
                n /= 2;
            } else {
                n = n * 3 + 1;
            }
        }

        return answer;
    }
}

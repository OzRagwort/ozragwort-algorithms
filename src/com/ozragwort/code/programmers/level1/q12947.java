package com.ozragwort.code.programmers.level1;

public class q12947 {
    public boolean solution(int x) {
        int o = x;
        int sum = 0;

        while (o > 0) {
            sum += o % 10;
            o /= 10;
        }

        boolean answer = x % sum == 0;
        return answer;
    }
}

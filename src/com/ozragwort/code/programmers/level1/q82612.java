package com.ozragwort.code.programmers.level1;

public class q82612 {
    public long solution(int price, int money, int count) {
        long totalPrice = 0;

        for (long i = 1 ; i <= count ; i++) {
            totalPrice += price * i;
        }

        long answer = totalPrice - money;
        return answer > 0 ? answer : 0;
    }
}

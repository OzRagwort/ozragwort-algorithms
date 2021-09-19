package com.ozragwort.code.programmers.level2;

public class q12911 {
    public int solution(int n) {
        int answer = n;
        int zeroCount = 0;
        int zeroIndex = 0;
        boolean meetOne = false;

        while (!meetOne || (answer & 1) == 1) {
            if ((answer & 1) == 0) {
                zeroCount++;
            } else {
                meetOne = true;
            }
            zeroIndex++;
            answer >>= 1;
        }

        int x = (int) (Math.pow(2, zeroIndex) + Math.pow(2, zeroIndex - zeroCount - 1) - 1);
        answer <<= zeroIndex;
        answer |= x;
        return answer;
    }
}

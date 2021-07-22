package com.ozragwort.code.programmers.level3;

import java.util.Arrays;

public class q12987 {
    public int solution(int[] A, int[] B) {
        int winPoint = 0;
        int positionA = 0;
        int positionB = 0;

        Arrays.sort(A);
        Arrays.sort(B);

        while (positionA < A.length && positionB < B.length) {
            if (A[positionA] < B[positionB]) {
                winPoint++;
                positionA++;
                positionB++;
            }
            else {
                positionB++;
            }
        }

        return winPoint;
    }
}

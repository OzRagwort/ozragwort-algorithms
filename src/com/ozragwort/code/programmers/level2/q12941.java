package com.ozragwort.code.programmers.level2;

import java.util.Arrays;

public class q12941 {
    public int solution(int[] A, int[] B) {
        int answer = 0;
        int length = A.length;

        Arrays.sort(A);
        Arrays.sort(B);

        for (int i = 0 ; i < length ; i++) {
            answer += A[i] * B[length - i - 1];
        }

        return answer;
    }
}

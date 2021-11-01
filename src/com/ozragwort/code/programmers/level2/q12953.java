package com.ozragwort.code.programmers.level2;

public class q12953 {
    public int solution(int[] arr) {
        int answer = arr[0];

        for (int i = 1 ; i < arr.length ; i++) {
            answer = answer * arr[i] / LCM(answer, arr[i]);
        }

        return answer;
    }

    public int LCM(int a, int b) {
        int big = Math.max(a, b);
        int small = Math.min(a, b);

        while (small > 0) {
            int remain = big % small;
            big = small;
            small = remain;
        }
        return big;
    }
}

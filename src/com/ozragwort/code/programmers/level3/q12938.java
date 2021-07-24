package com.ozragwort.code.programmers.level3;

public class q12938 {
    public int[] solution(int n, int s) {
        int num = s / n;
        int modCount = s % n;

        if (num == 0) {
            return new int[]{-1};
        } else {
            int[] answer = new int[n];
            for (int i = 0 ; i < n - modCount ; i++) {
                answer[i] = num;
            }
            for (int i = n - modCount ; i < n ; i++) {
                answer[i] = num + 1;
            }
            return answer;
        }
    }
}

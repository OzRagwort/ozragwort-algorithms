package com.ozragwort.code.programmers.level1;

import java.util.Arrays;

public class q12921 {
    public int solution(int n) {
        int answer = 0;
        boolean[] check = new boolean[n + 1];
        Arrays.fill(check, true);

        for (int i = 2 ; i <= n ; i++) {
            if (check[i]) {
                answer++;
                for (int j = i + i ; j <= n ; j+=i) {
                    check[j] = false;
                }
            }
        }

        return answer;
    }
}

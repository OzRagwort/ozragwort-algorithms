package com.ozragwort.code.programmers.level1;

import java.util.HashSet;

public class q12928 {
    public int solution(int n) {
        HashSet<Integer> set = new HashSet<>();

        for (int i = 1 ; i * i <= n ; i++) {
            if (n % i == 0) {
                set.add(i);
                set.add(n / i);
            }
        }

        int answer = set.stream().mapToInt(Integer::intValue).sum();
        return answer;
    }
}

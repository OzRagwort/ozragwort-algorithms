package com.ozragwort.code.programmers.level1;

import java.util.Arrays;

public class q12915 {
    public String[] solution(String[] strings, int n) {
        Arrays.sort(strings, (o1, o2) -> {
            if (o1.charAt(n) == o2.charAt(n)) {
                return o1.compareTo(o2);
            } else {
                return o1.charAt(n) - o2.charAt(n);
            }
        });

        return strings;
    }
}

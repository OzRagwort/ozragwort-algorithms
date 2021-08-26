package com.ozragwort.code.programmers.level2;

import java.util.HashMap;

public class q84512 {
    public int solution(String word) {
        int answer = 0;

        HashMap<Character, Integer> map = new HashMap<>();
        map.put('A', 1);
        map.put('E', 2);
        map.put('I', 3);
        map.put('O', 4);
        map.put('U', 5);

        int[] weight = new int[5];
        for (int i = 3 ; i >= 0 ; i--) {
            weight[i] = (weight[i + 1] + 1) * 5;
        }

        for (int i = 0 ; i < word.length() ; i++) {
            char c = word.charAt(i);
            int n = map.get(c);
            answer += (n - 1) * weight[i] + n;
        }

        return answer;
    }
}

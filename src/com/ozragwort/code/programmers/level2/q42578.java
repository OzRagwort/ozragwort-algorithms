package com.ozragwort.code.programmers.level2;

import java.util.HashMap;

public class q42578 {
    public int solution(String[][] clothes) {
        HashMap<String, Integer> map = new HashMap<>();

        for (String[] cloth : clothes) {
            if (map.containsKey(cloth[1])) {
                map.put(cloth[1], map.get(cloth[1]) + 1);
            } else {
                map.put(cloth[1], 2);
            }
        }

        int answer = 1;

        for (String key : map.keySet()) {
            answer *= map.get(key);
        }

        return answer - 1;
    }
}

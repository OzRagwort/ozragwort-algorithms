package com.ozragwort.code.programmers.level1;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class q17682 {
    public int solution(String dartResult) {
        List<Integer> list = new ArrayList<>();

        HashMap<Character, Integer> weight = new HashMap<>();
        weight.put('S', 1);
        weight.put('D', 2);
        weight.put('T', 3);
        weight.put('*', 2);
        weight.put('#', -1);

        StringBuilder sb = new StringBuilder();
        int index = -1;
        for (int i = 0 ; i < dartResult.length() ; i++) {
            char c = dartResult.charAt(i);
            if (c == 'S' || c == 'D' || c == 'T') {
                list.add((int) Math.pow(Integer.parseInt(sb.toString()), weight.get(c)));
                sb = new StringBuilder();
                index++;
            } else if (c == '*' || c == '#') {
                list.set(index, list.get(index) * weight.get(c));
                if (index != 0 && c == '*') {
                    list.set(index - 1, list.get(index - 1) * weight.get(c));
                }
            } else {
                sb.append(dartResult.charAt(i));
            }
        }

        int answer = list.stream().mapToInt(Integer::intValue).sum();
        return answer;
    }
}

package com.ozragwort.code.programmers.level2;

import java.util.HashSet;

public class q12981 {
    public int[] solution(int n, String[] words) {
        HashSet<String> set = new HashSet<>();
        int[] answer = new int[]{0, 0};
        char prevWord = words[0].charAt(0);
        int count = 0;

        for (String word : words) {
            if (set.contains(word) || word.charAt(0) != prevWord) {
                answer[0] = (count % n) + 1;
                answer[1] = (count / n) + 1;
                break;
            } else {
                count++;
                set.add(word);
                prevWord = word.charAt(word.length() - 1);
            }
        }

        return answer;
    }
}

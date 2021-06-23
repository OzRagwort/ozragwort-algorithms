package com.ozragwort.code.programmers.level1;

import java.util.Arrays;

public class q42576 {
    public String solution(String[] participant, String[] completion) {
        String answer = "";
        int len = completion.length;

        Arrays.sort(participant);
        Arrays.sort(completion);

        answer = participant[len];
        for (int i = 0 ; i < len ; i++) {
            if (!participant[i].equals(completion[i])) {
                answer = participant[i];
                break;
            }
        }

        return answer;
    }
}

package com.ozragwort.code.programmers.level1;

import java.util.HashSet;

public class q77484 {
    public int[] solution(int[] lottos, int[] win_nums) {
        int[] answer = new int[2];
        int zeroCounter = 0;

        HashSet<Integer> hashSet = new HashSet<>();
        for (int w : win_nums) {
            hashSet.add(w);
        }

        for (int i = 0 ; i < 6 ; i++) {
            if (lottos[i] == 0) {
                zeroCounter++;
            } else {
                hashSet.remove(lottos[i]);
            }
        }

        answer[1] = hashSet.size() >= 6 ? 6 : hashSet.size() + 1;
        answer[0] = Math.max(answer[1] - zeroCounter, 1);

        return answer;
    }
}

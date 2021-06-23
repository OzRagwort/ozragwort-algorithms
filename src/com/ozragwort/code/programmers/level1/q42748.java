package com.ozragwort.code.programmers.level1;

import java.util.Arrays;

public class q42748 {
    public int[] solution(int[] array, int[][] commands) {
        int[] answer = new int[commands.length];

        for (int i = 0 ; i < commands.length ; i++) {
            int size = commands[i][1] - commands[i][0] + 1;
            int[] t = new int[size];
            System.arraycopy(array, commands[i][0] - 1, t, 0, size);
            Arrays.sort(t);
            answer[i] = t[commands[i][2] - 1];
        }

        return answer;
    }
}

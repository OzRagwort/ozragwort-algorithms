package com.ozragwort.code.programmers.level2;

public class q42842 {
    public int[] solution(int brown, int yellow) {
        for (int i = 1 ; i < 5000 ; i++) {
            for (int j = 1 ; j <= i ; j++) {
                if (i + j == (brown + 4) / 2 && i * j == brown + yellow) {
                    return new int[]{i, j};
                }
            }
        }
        return null;
    }
}

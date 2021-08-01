package com.ozragwort.code.programmers.level2;

public class q62048 {
    public long solution(int w, int h) {
        long total = (long) w * h;
        long useless = 0;

        long shorter = Math.min(w, h);
        long longer = Math.max(w, h);

        for (int i = 0 ; i < shorter ; i++) {
            int prevPoint = (int) ((longer * i) / shorter);
            int nextPoint = (int) (((longer * (i + 1)) + shorter - 1) / shorter);

            useless += nextPoint - prevPoint;
        }

        return total - useless;
    }
}

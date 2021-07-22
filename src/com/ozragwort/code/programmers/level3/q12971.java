package com.ozragwort.code.programmers.level3;

public class q12971 {
    public int solution(int sticker[]) {
        int max = 0;
        int[] dpA = new int[sticker.length];
        int[] dpB = new int[sticker.length];

        if (sticker.length <= 3) {
            for (int s : sticker) {
                if (max < s) {
                    max = s;
                }
            }
        } else {
            System.arraycopy(sticker, 0, dpA, 0, 3);
            System.arraycopy(sticker, 0, dpB, 0, 2);
            for (int i = 3 ; i < sticker.length ; i++) {
                dpA[i] = Math.max(dpA[Math.max(1, i - 3)], dpA[i - 2]) + sticker[i];
                dpB[i - 1] = Math.max(dpB[Math.max(0, i - 4)], dpB[i - 3]) + sticker[i - 1];

                int partMax = Math.max(dpA[i], dpB[i - 1]);
                if (max < partMax) {
                    max = partMax;
                }
            }
        }

        return max;
    }
}

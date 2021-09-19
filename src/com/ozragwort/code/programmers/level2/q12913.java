package com.ozragwort.code.programmers.level2;

public class q12913 {
    int solution(int[][] land) {
        int[][] dp = new int[land.length][4];

        System.arraycopy(land[0], 0, dp[0], 0, 4);

        for (int i = 1 ; i < land.length ; i++) {
            for (int j = 0 ; j < 4 ; j++) {
                dp[i][j] = land[i][j] + getMax(dp[i - 1], j);
            }
        }

        int answer = 0;

        for (int i = 0 ; i < 4 ; i++) {
            if (answer < dp[land.length - 1][i]) {
                answer = dp[land.length - 1][i];
            }
        }

        return answer;
    }

    public int getMax(int[] value, int index) {
        int max = 0;
        for (int i = 0 ; i < 4 ; i++) {
            if (index != i) {
                max = Math.max(max, value[i]);
            }
        }
        return max;
    }
}

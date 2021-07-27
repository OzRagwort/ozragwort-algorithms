package com.ozragwort.code.programmers.level4;

public class q42897 {
    public int solution(int[] money) {
        int[] dp = new int[money.length];
        int[] dpSub = new int[money.length];
        int max = 0;

        dp[0] = 0;
        dp[1] = money[1];
        dpSub[0] = money[0];
        dpSub[1] = money[1];

        for (int i = 2 ; i < money.length ; i++) {
            dp[i] = Math.max(dp[i - 2] + money[i], dp[i - 1]);
            dpSub[i] = Math.max(dpSub[i - 2] + money[i], dpSub[i - 1]);
        }

        max = Math.max(dp[money.length - 1], dpSub[money.length - 2]);

        return max;
    }
}

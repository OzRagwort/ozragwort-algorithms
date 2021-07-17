package com.ozragwort.code.programmers.level3;

public class q12907 {
    public int solution(int n, int[] money) {
        int[][] calc = new int[money.length][n + 1];
        int[] counter = new int[n + 1];
        int MOD = 1000000007;

        counter[0] = 1;
        for (int i = 0 ; i < money.length ; i++) {
            for (int j = 1 ; j <= n ; j++) {
                if (j >= money[i]) {
                    calc[i][j] = counter[j - money[i]];
                    counter[j] += calc[i][j];
                    counter[j] %= MOD;
                }
            }
        }

        return counter[n];
    }
}

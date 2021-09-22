package com.ozragwort.code.programmers.level3;

public class q1832 {
    int MOD = 20170805;
    int[] di = new int[]{-1, 0};
    int[] dj = new int[]{0, -1};

    public int solution(int m, int n, int[][] cityMap) {
        int[][] dp = new int[m][n];

        dp[0][0] = 1;
        for (int i = 0 ; i < m ; i++) {
            for (int j = 0 ; j < n ; j++) {
                if (cityMap[i][j] == 0) {
                    for (int d = 0 ; d < 2 ; d++) {
                        dp[i][j] += getCase(dp, cityMap, i, j, d);
                    }
                    dp[i][j] %= MOD;
                }
            }
        }

        return dp[m - 1][n - 1];
    }

    public int getCase(int[][] dp, int[][] cityMap, int i, int j, int d) {
        while (true) {
            i += di[d];
            j += dj[d];

            if (check(i, j)) {
                if (cityMap[i][j] == 0) {
                    return dp[i][j];
                } else if (cityMap[i][j] == 1) {
                    return 0;
                } else {
                    continue;
                }
            } else {
                return 0;
            }
        }
    }

    public boolean check(int i, int j) {
        return 0 <= i && 0 <= j;
    }
}

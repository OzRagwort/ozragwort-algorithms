package com.ozragwort.code.programmers.level4;

public class q12942 {
    Integer[][] dp;
    int[][] mul;

    public int solution(int[][] matrix_sizes) {
        dp = new Integer[matrix_sizes.length][matrix_sizes.length];
        mul = new int[matrix_sizes.length][matrix_sizes.length];

        for (int i = 0 ; i < matrix_sizes.length ; i++) {
            for (int j = i + 1 ; j < matrix_sizes.length ; j++) {
                mul[i][j] = matrix_sizes[i][0] * matrix_sizes[j][1];
            }
        }

        int answer = getDp(matrix_sizes, 0, matrix_sizes.length - 1);
        return answer;
    }

    public int getDp(int[][] matrix, int s, int e) {
        if (dp[s][e] == null) {
            if (s == e) {
                dp[s][e] = 0;
            } else {
                dp[s][e] = Integer.MAX_VALUE;
                for (int i = s ; i < e ; i++) {
                    dp[s][e] = Math.min(dp[s][e], getDp(matrix, s, i) + getDp(matrix, i + 1, e) + mul[s][e] * matrix[i][1]);
                }
            }
        }
        return dp[s][e];
    }
}

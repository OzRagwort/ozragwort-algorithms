package com.ozragwort.code.programmers.level2;

public class q12905 {
    public int solution(int [][] board) {
        int[][] dp = new int[board.length][board[0].length];
        int answer = 0;

        for (int i = 0 ; i < board.length ; i++) {
            for (int j = 0 ; j < board[0].length ; j++) {
                if (i == 0 || j == 0) {
                    dp[i][j] = board[i][j];
                } else {
                    if (board[i][j] == 1) {
                        dp[i][j] = Math.min(dp[i - 1][j - 1], Math.min(dp[i - 1][j], dp[i][j - 1])) + 1;
                    } else {
                        dp[i][j] = 0;
                    }
                }

                if (answer < dp[i][j]) {
                    answer = dp[i][j];
                }
            }
        }

        return answer * answer;
    }
}

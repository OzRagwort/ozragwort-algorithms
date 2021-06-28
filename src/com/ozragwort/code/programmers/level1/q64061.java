package com.ozragwort.code.programmers.level1;

import java.util.Stack;

public class q64061 {
    public int solution(int[][] board, int[] moves) {
        int answer = 0;
        Stack<Integer> stack = new Stack<>();
        int S = board.length;

        for (int m : moves) {
            for (int i = 0 ; i < S ; i++) {
                if (board[i][m - 1] != 0) {
                    if (!stack.isEmpty() && stack.peek() == board[i][m - 1]) {
                        stack.pop();
                        answer += 2;
                    } else {
                        stack.push(board[i][m - 1]);
                    }
                    board[i][m - 1] = 0;
                    break;
                }
            }
        }

        return answer;
    }
}

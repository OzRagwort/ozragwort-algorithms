package com.ozragwort.code.programmers.level3;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;

public class q60063 {
    Queue<Integer[]> queue = new LinkedList<>();
    HashSet<Integer> visit = new HashSet<>();
    int[][] board;
    int[] dx = new int[]{0, 0, 1, -1};
    int[] dy = new int[]{1, -1, 0, 0};
    int length = 0;

    public int solution(int[][] board) {
        int answer = 0;
        this.board = board;
        length = board.length;
        int finish = length * length - 1;

        // 좌표 1, 좌표 2, 이동 횟수
        queue.offer(new Integer[]{0, 1, 0});
        visit.add(1);

        while (!queue.isEmpty()) {
            Integer[] p = queue.poll();

            if (p[0] == finish || p[1] == finish) {
                answer = p[2];
                break;
            } else {
                bps(p[0], p[1], p[2]);
            }
        }

        return answer;
    }

    public void bps(int p1, int p2, int count) {
        int[][] position = new int[][]{
                {p1 / length, p1 % length},
                {p2 / length, p2 % length}
        };

        for (int i = 0 ; i < 4 ; i++) {
            int x1 = position[0][0] + dx[i];
            int y1 = position[0][1] + dy[i];
            int x2 = position[1][0] + dx[i];
            int y2 = position[1][1] + dy[i];
            int np1 = x1 * length + y1;
            int np2 = x2 * length + y2;

            if (positionCheck(x1, y1)
                    && positionCheck(x2, y2)
                    && board[x1][y1] == 0
                    && board[x2][y2] == 0) {

                // 상하좌우 이동
                addQueue(np1, np2, count);

                // 회전
                if (position[0][0] == position[1][0] && i >= 2 || position[0][1] == position[1][1] && i < 2) {
                    if (i % 2 == 0) {
                        addQueue(p1, np1, count);
                        addQueue(p2, np2, count);
                    } else {
                        addQueue(np1, p1, count);
                        addQueue(np2, p2, count);
                    }
                }
            }
        }
    }

    public void addQueue(int p1, int p2, int count) {
        if (!visit.contains(p1 * length + p2)) {
            queue.offer(new Integer[]{p1, p2, count + 1});
            visit.add(p1 * length + p2);
        }
    }

    public boolean positionCheck(int x, int y) {
        return 0 <= x && x < length && 0 <= y && y < length;
    }
}

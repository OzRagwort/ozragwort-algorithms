package com.ozragwort.code.programmers.level2;

import java.util.LinkedList;
import java.util.Queue;

public class q1844 {
    Queue<Positon> queue = new LinkedList<>();
    int[][] maps;
    boolean[][] visit;
    int[] dx = new int[]{1,-1,0,0};
    int[] dy = new int[]{0,0,1,-1};

    public class Positon {
        int x;
        int y;

        public Positon(int x, int y) {
            this.x = x;
            this.y = y;
        }

        public int getX() {
            return x;
        }

        public int getY() {
            return y;
        }
    }

    public int solution(int[][] maps) {
        int answer = -1;
        int n = maps.length;
        int m = maps[0].length;
        this.maps = maps;
        visit = new boolean[n][m];

        for (int i = 0 ; i < n ; i++) {
            for (int j = 0 ; j < m ; j++) {
                if (maps[i][j] == 1) {
                    visit[i][j] = true;
                }
            }
        }

        queue.add(new Positon(0, 0));
        visit[0][0] = false;
        while (!queue.isEmpty()) {
            Positon position = queue.poll();
            if (position.getX() == n - 1 && position.getY() == m - 1) {
                answer = maps[n - 1][m - 1];
                break;
            }
            bps(position);
        }

        return answer;
    }

    public void bps(Positon position) {
        int x = position.getX();
        int y = position.getY();

        for (int i = 0 ; i < 4 ; i++) {
            int X = x + dx[i];
            int Y = y + dy[i];

            if (0 <= X && X < maps.length && 0 <= Y && Y < maps[0].length) {
                if (visit[X][Y]) {
                    queue.add(new Positon(X, Y));
                    visit[X][Y] = false;
                    maps[X][Y] = maps[x][y] + 1;
                }
            }
        }
    }
}

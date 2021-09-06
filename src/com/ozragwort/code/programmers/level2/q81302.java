package com.ozragwort.code.programmers.level2;

public class q81302 {
    int[] dx = new int[]{1, -1, 0, 0};
    int[] dy = new int[]{0, 0, 1, -1};

    public int[] solution(String[][] places) {
        int[] answer = new int[places.length];

        for (int i = 0 ; i < places.length ; i++) {
            char[][] p = new char[5][5];

            for (int j = 0 ; j < 5 ; j++) {
                p[j] = places[i][j].toCharArray();
            }

            answer[i] = check(p);
        }

        return answer;
    }

    public int check(char[][] p) {
        for (int x = 0 ; x < 5 ; x++) {
            for (int y = 0 ; y < 5 ; y++) {
                int impossibleCount = 0;
                if (p[x][y] == 'P') {
                    impossibleCount = 1;
                } else if (p[x][y] == 'O') {
                    impossibleCount = 2;
                } else {
                    continue;
                }

                if (getEqualCount(p, x, y, 'P') >= impossibleCount) {
                    return 0;
                }
            }
        }
        return 1;
    }

    public int getEqualCount(char[][] p, int x, int y, char c) {
        int count = 0;

        for (int i = 0 ; i < 4 ; i++) {
            int X = x + dx[i];
            int Y = y + dy[i];

            if (0 <= X && X < 5 && 0 <= Y && Y < 5 && p[X][Y] == c) {
                count++;
            }
        }

        return count;
    }
}

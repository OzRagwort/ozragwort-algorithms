package com.ozragwort.code.programmers.level2;

public class q49994 {
    public int solution(String dirs) {
        boolean[][][] table = new boolean[11][11][2];
        int answer = 0;
        int x = 5;
        int y = 5;

        for (int i = 0 ; i < dirs.length() ; i++) {
            char c = dirs.charAt(i);
            int dx = 0, dy = 0, nx = 0, ny = 0, dir = 0;

            if (c == 'U') {
                nx = x;
                ny = y + 1;
                dx = x;
                dy = y;
                dir = 1;
            } else if (c == 'D') {
                nx = x;
                ny = y - 1;
                dx = x;
                dy = y - 1;
                dir = 1;
            } else if (c == 'R') {
                nx = x + 1;
                ny = y;
                dx = x;
                dy = y;
                dir = 0;
            } else if (c == 'L') {
                nx = x - 1;
                ny = y;
                dx = x - 1;
                dy = y;
                dir = 0;
            }

            if (0 <= nx && nx < 11 && 0 <= ny && ny < 11) {
                if (!table[dx][dy][dir]) {
                    table[dx][dy][dir] = true;
                    answer++;
                }
                x = nx;
                y = ny;
            }
        }

        return answer;
    }
}

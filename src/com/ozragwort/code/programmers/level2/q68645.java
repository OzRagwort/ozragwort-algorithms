package com.ozragwort.code.programmers.level2;

public class q68645 {
    int[] dx = new int[]{1, 0, -1};
    int[] dy = new int[]{0, 1, -1};

    public int[] solution(int n) {
        int size = sum(n);
        int[] answer = new int[size];
        int[][] table = new int[n][n];
        int x = 0, y = 0, prevDirection = 0;

        for (int i = 1 ; i <= size ; i++) {
            table[x][y] = i;

            for (int j = prevDirection ; j < (prevDirection + 3) ; j++) {
                int tx = x + dx[j % 3];
                int ty = y + dy[j % 3];

                if (0 <= tx && tx < n && 0 <= ty && ty < n) {
                    if (table[tx][ty] == 0) {
                        x = tx;
                        y = ty;
                        prevDirection = j % 3;
                        break;
                    }
                }
            }
        }

        int index = 0;
        for (int i = 0 ; i < n ; i++) {
            for (int j = 0 ; j <= i ; j++) {
                answer[index] = table[i][j];
                index++;
            }
        }

        return answer;
    }

    public int sum(int n) {
        if (n == 1) {
            return 1;
        } else {
            return n + sum(n - 1);
        }
    }
}

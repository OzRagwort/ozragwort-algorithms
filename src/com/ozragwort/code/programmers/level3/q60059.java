package com.ozragwort.code.programmers.level3;

public class q60059 {
    int[] dx;
    int[] dy;

    public boolean solution(int[][] key, int[][] lock) {
        int dSize = key.length + lock.length - 1;
        dx = dy = new int[dSize];

        dx[0] = dy[0] = (lock.length * -1) + 1;
        for (int i = 1 ; i < dSize ; i++) {
            dx[i] = dy[i] = dx[i - 1] + 1;
        }

        for (int rotation = 0 ; rotation < 4 ; rotation++) {
            for (int r = 0 ; r < dSize ; r++) {
                for (int c = 0 ; c < dSize ; c++) {
                    if (check(key, lock, r, c)) {
                        return true;
                    }
                }
            }
            key = rotation(key);
        }

        return false;
    }

    public boolean check(int[][] key, int[][] lock, int r, int c) {
        for (int i = 0 ; i < lock.length ; i++) {
            for (int j = 0 ; j < lock.length ; j++) {
                if (0 <= i + dx[r] && i + dx[r] < key.length && 0 <= j + dy[c] && j + dy[c] < key.length) {
                    if ((lock[i][j] ^ key[i + dx[r]][j + dy[c]]) == 0) {
                        return false;
                    }
                } else if (lock[i][j] == 0) {
                    return false;
                } else {
                    continue;
                }
            }
        }
        return true;
    }

    public int[][] rotation(int[][] key) {
        int[][] rotationKey = new int[key.length][key.length];
        for (int i = 0 ; i < key.length ; i++) {
            for (int j = 0 ; j < key.length ; j++) {
                rotationKey[j][key.length - i - 1] = key[i][j];
            }
        }
        return rotationKey;
    }
}

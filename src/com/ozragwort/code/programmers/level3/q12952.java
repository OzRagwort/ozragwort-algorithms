package com.ozragwort.code.programmers.level3;

public class q12952 {
    boolean[][] table;
    int n;
    int counter = 0;

    public int solution(int n) {
        table = new boolean[n][n];
        this.n = n;

        dfs(0);

        return counter;
    }

    public void dfs(int depth) {
        if (depth == n) {
            counter++;
        } else {
            for (int i = 0 ; i < n ; i++) {
                if (!table[depth][i] && check(depth, i)) {
                    table[depth][i] = true;
                    dfs(depth + 1);
                    table[depth][i] = false;
                }
            }
        }
    }

    public boolean check(int x, int y) {

        for (int i = 0 ; i <= x ; i++) {
            if (table[i][y]) return false;
            if (y - i >= 0 && table[x-i][y-i]) return false;
            if (y + i < n && table[x-i][y+i]) return false;
        }
        return true;
    }
}

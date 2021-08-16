package com.ozragwort.code.programmers.level3;

public class q72413 {
    public int solution(int n, int s, int a, int b, int[][] fares) {
        int[][] table = new int[n + 1][n + 1];
        int INF = 1000000;

        for (int[] fare : fares) {
            table[fare[0]][fare[1]] = fare[2];
            table[fare[1]][fare[0]] = fare[2];
        }

        for (int i = 1 ; i <= n ; i++) {
            for (int j = 1; j <= n; j++) {
                if (i != j && table[i][j] == 0) {
                    table[i][j] = INF;
                }
            }
        }

        for (int m = 1 ; m <= n ; m++) {
            for (int i = 1 ; i <= n ; i++) {
                for (int j = 1 ; j <= n ; j++) {
                    if (i == j || i == m || j == m) {
                        continue;
                    } else {
                        table[i][j] = Math.min(table[i][j], table[i][m] + table[m][j]);
                    }
                }
            }
        }

        int min = Integer.MAX_VALUE;
        for (int i = 1 ; i <= n ; i++) {
            int cost = table[s][i] + table[i][a] + table[i][b];
            if (cost < min) {
                min = cost;
            }
        }

        return min;
    }
}

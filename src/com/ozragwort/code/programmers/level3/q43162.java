package com.ozragwort.code.programmers.level3;

public class q43162 {
    int[][] computers;
    boolean[] visit;
    int counter = 0, n;

    public int solution(int n, int[][] computers) {
        this.computers = computers;
        this.n = n;
        visit = new boolean[n];

        for (int i = 0 ; i < n ; i++) {
            if (!visit[i]) {
                dfs(i);
                counter++;
            }
        }

        return counter;
    }

    public void dfs(int p) {
        visit[p] = true;
        for (int i = 0 ; i < n ; i++) {
            if (!visit[i] && computers[p][i] == 1) {
                dfs(i);
            }
        }
    }
}

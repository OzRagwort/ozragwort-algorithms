package com.ozragwort.code.programmers.level3;

import java.util.Arrays;
import java.util.Comparator;

public class q42861 {
    boolean[][] bridge;
    boolean[] visit;
    int n;

    public int solution(int n, int[][] costs) {
        int answer = 0;

        bridge = new boolean[n][n];
        visit = new boolean[n];
        this.n = n;

        Arrays.sort(costs, Comparator.comparingInt(o -> o[2]));

        for (int[] cost : costs) {
            Arrays.fill(visit, false);
            dfs(cost[0]);
            if (visitCheck()) {
                break;
            } else if (visit[cost[1]]) {
                continue;
            } else {
                bridge[cost[0]][cost[1]] = bridge[cost[1]][cost[0]] = true;
                answer += cost[2];
            }
        }

        return answer;
    }

    public void dfs(int i) {
        for (int k = 0 ; k < n ; k++) {
            if (bridge[i][k]) {
                if (visit[k]) {
                    continue;
                } else {
                    visit[k] = true;
                    dfs(k);
                }
            }
        }
    }

    public boolean visitCheck() {
        for (int i = 0 ; i < n ; i++) {
            if (visit[i]) {
                continue;
            } else {
                return false;
            }
        }
        return true;
    }
}

package com.ozragwort.code.programmers.level2;

public class q87946 {
    public int solution(int k, int[][] dungeons) {
        int answer = dfs(dungeons, new boolean[dungeons.length], k, 0, 0, 0);
        return answer;
    }

    public int dfs(int[][] dungeons, boolean[] visit, int k, int depth, int max, int count) {
        if (depth < dungeons.length) {
            for (int i = 0 ; i < dungeons.length ; i++) {
                if (!visit[i]) {
                    if (dungeons[i][0] <= k) {
                        k -= dungeons[i][1];
                        count++;
                        visit[i] = true;
                        max = dfs(dungeons, visit, k, depth + 1, max, count);
                        visit[i] = false;
                        count--;
                        k += dungeons[i][1];
                    }
                }
            }
        }
        return Math.max(max, count);
    }
}

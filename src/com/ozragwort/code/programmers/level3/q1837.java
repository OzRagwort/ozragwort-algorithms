package com.ozragwort.code.programmers.level3;

public class q1837 {
    public int solution(int n, int m, int[][] edge_list, int k, int[] gps_log) {
        int[][] edge_dist = new int[n][n];
        int[] dp = new int[gps_log.length];

        // 패딩
        for (int i = 0 ; i < edge_dist.length ; i++) {
            for (int j = 0 ; j < edge_dist.length ; j++) {
                if (i != j) {
                    edge_dist[i][j] = 1000000000;
                }
            }
        }

        // edge 입력
        for (int[] edge : edge_list) {
            edge_dist[edge[0] - 1][edge[1] - 1] = 1;
            edge_dist[edge[1] - 1][edge[0] - 1] = 1;
        }

        // 최단 거리 계산
        for (int mid = 0 ; mid < n ; mid++) {
            for (int s = 0 ; s < n ; s++) {
                for (int e = 0 ; e < n ; e++) {
                    if (s == e || s == mid || e == mid) {
                        continue;
                    } else {
                        edge_dist[s][e] = Math.min(edge_dist[s][e], edge_dist[s][mid] + edge_dist[mid][e]);
                    }
                }
            }
        }

        // dp 계산
        for (int i = 1 ; i < gps_log.length ; i++) {
            int count = -1;
            for (int j = i - 1 ; j >= 0 ; j--) {
                if (dp[j] != -1) {
                    int start = gps_log[j] - 1;
                    int end = gps_log[i] - 1;
                    if (edge_dist[start][end] <= i - j) {
                        count = dp[j] + i - j - 1;
                        break;
                    }
                }
            }
            dp[i] = count;
        }

        return dp[gps_log.length - 1];
    }
}

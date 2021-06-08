package com.ozragwort.code.baekjoon;

import java.io.*;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class q2421 {

    int N;
    int[][] dp;
    int[] prime;
    Queue<Integer[]> queue = new LinkedList<>();
    int[] dx = new int[]{1, 0};
    int[] dy = new int[]{0, 1};
    boolean[][] visit;

    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String in = br.readLine();
        N = Integer.parseInt(in);
        int maxNum = Integer.parseInt(in + in);
        dp = new int[N + 1][N + 1];
        visit = new boolean[N + 1][N + 1];
        prime = new int[maxNum + 1];
        Arrays.fill(prime, 1);

        for (int i = 2 ; i <= maxNum ; i++) {
            if (prime[i] == 1) {
                for (int j = i + i ; j <= maxNum ; j+=i) {
                    prime[j] = 0;
                }
            }
        }

        queue.offer(new Integer[]{1, 1});
        while (!queue.isEmpty()) {
            Integer[] num = queue.poll();
            bfs(num[0], num[1]);
        }

        System.out.println(dp[N][N]);

    }

    public void bfs(int a, int b) {
        for (int i = 0 ; i < 2 ; i++) {
            int x = a + dx[i];
            int y = b + dy[i];

            if (x <= N && y <= N) {
                int num = 0;

                for (int p = 1 ; p <= 3 ; p++) {
                    if (y < Math.pow(10, p)) {
                        num = (x * (int) Math.pow(10, p)) + y;
                        break;
                    }
                }

                dp[x][y] = Math.max(dp[x][y], dp[a][b] + prime[num]);
                if (visit[x][y]) {
                    continue;
                } else {
                    queue.offer(new Integer[]{x, y});
                    visit[x][y] = true;
                }
            }
        }
    }
}

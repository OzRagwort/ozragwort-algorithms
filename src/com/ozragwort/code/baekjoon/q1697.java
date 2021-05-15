package com.ozragwort.code.baekjoon;

import java.io.*;
import java.util.*;

public class q1697 {

    Queue<Integer> queue = new LinkedList<>();
    int[] dp = new int[100001];
    boolean[] visit = new boolean[100001];
    int N, K, counter = 0;

    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stk = new StringTokenizer(br.readLine());
        N = Integer.parseInt(stk.nextToken());
        K = Integer.parseInt(stk.nextToken());

        queue.offer(N);
        visit[N] = true;
        while (!queue.isEmpty()) {
            int n = queue.poll();
            if (n == K) {
                counter = dp[n];
                break;
            }
            bfs(n);
        }

        System.out.print(counter);
    }

    public void bfs(int n) {
        if (n - 1 >= 0 && !visit[n - 1]) {
            queue.offer(n - 1);
            visit[n - 1] = true;
            dp[n - 1] = dp[n] + 1;
        }
        if (n + 1 <= 100000 && !visit[n + 1]) {
            queue.offer(n + 1);
            visit[n + 1] = true;
            dp[n + 1] = dp[n] + 1;
        }
        if (n * 2 <= 100000 && !visit[n * 2]) {
            queue.offer(n * 2);
            visit[n * 2] = true;
            dp[n * 2] = dp[n] + 1;
        }
    }
}

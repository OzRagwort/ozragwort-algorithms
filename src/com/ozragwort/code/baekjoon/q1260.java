package com.ozragwort.code.baekjoon;

import java.io.*;
import java.util.*;

public class q1260 {

    StringBuilder sb = new StringBuilder();
    boolean[][] table;
    Queue<Integer> queue = new LinkedList<>();
    boolean[] check;
    int N;

    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stk = new StringTokenizer(br.readLine());
        N = Integer.parseInt(stk.nextToken());
        int M = Integer.parseInt(stk.nextToken());
        int V = Integer.parseInt(stk.nextToken());
        table = new boolean[N][N];

        for (int i = 0 ; i < M ; i++) {
            stk = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(stk.nextToken());
            int b = Integer.parseInt(stk.nextToken());
            table[a - 1][b - 1] = true;
            table[b - 1][a - 1] = true;
        }

        check = new boolean[N];
        DFS(V);
        sb.append("\n");

        check = new boolean[N];
        queue.offer(V);
        check[V - 1] = true;
        while (!queue.isEmpty()) {
            BFS(queue.poll());
        }

        System.out.println(sb);
    }

    public void DFS(int target) {
        check[target - 1] = true;
        sb.append(target).append(" ");

        for (int i = 1 ; i <= N ; i++) {
            if (table[target - 1][i - 1] && !check[i - 1]) {
                DFS(i);
            }
        }
    }

    public void BFS(int target) {
        sb.append(target).append(" ");

        for (int i = 1 ; i <= N ; i++) {
            if (table[target - 1][i - 1] && !check[i - 1]) {
                queue.offer(i);
                check[i - 1] = true;
            }
        }
    }
}

package com.ozragwort.code.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class q2606 {

    int counter = 0;
    boolean[][] table;
    Queue<Integer> queue = new LinkedList<>();
    boolean[] check;
    int N;

    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stk;
        N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());
        table = new boolean[N][N];

        for (int i = 0 ; i < M ; i++) {
            stk = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(stk.nextToken());
            int b = Integer.parseInt(stk.nextToken());
            table[a - 1][b - 1] = true;
            table[b - 1][a - 1] = true;
        }

//        DFS
        check = new boolean[N];
        DFS(1);

//        BFS
//        check = new boolean[N];
//        queue.offer(1);
//        check[0] = true;
//        while (!queue.isEmpty()) {
//            BFS(queue.poll());
//        }

        System.out.println(counter - 1);
    }

    public void DFS(int target) {
        check[target - 1] = true;
        counter++;

        for (int i = 1 ; i <= N ; i++) {
            if (table[target - 1][i - 1] && !check[i - 1]) {
                DFS(i);
            }
        }
    }

    public void BFS(int target) {
        counter++;

        for (int i = 1 ; i <= N ; i++) {
            if (table[target - 1][i - 1] && !check[i - 1]) {
                queue.offer(i);
                check[i - 1] = true;
            }
        }
    }
}

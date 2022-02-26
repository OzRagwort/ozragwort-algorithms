package com.ozragwort.code.baekjoon;

import java.io.*;
import java.util.*;

public class q1325 {

    int N, M, max;
    List<Integer>[] lists;
    int[] counter;

    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer stk = new StringTokenizer(br.readLine());
        N = Integer.parseInt(stk.nextToken());
        M = Integer.parseInt(stk.nextToken());
        lists = new List[N + 1];
        counter = new int[N + 1];

        for (int i = 0 ; i <= N ; i++) {
            lists[i] = new ArrayList<>();
        }

        for (int i = 0 ; i < M ; i++) {
            stk = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(stk.nextToken());
            int end = Integer.parseInt(stk.nextToken());
            lists[start].add(end);
        }

        for (int i = 1 ; i <= N ; i++) {
            boolean[] visit = new boolean[N + 1];
            dfs(i, visit);
        }

        for (int i = 1 ; i <= N ; i++) {
            if (max < counter[i]) {
                max = counter[i];
            }
        }

        for (int i = 1 ; i <= N ; i++) {
            if (max == counter[i]) {
                bw.write(i + " ");
            }
        }

        bw.flush();
        bw.close();
        br.close();
    }

    public void dfs(int n, boolean[] visit) {
        if (visit[n]) {
            return;
        } else {
            visit[n] = true;
            counter[n]++;
            for (Integer l : lists[n]) {
                dfs(l, visit);
            }
        }
    }
}

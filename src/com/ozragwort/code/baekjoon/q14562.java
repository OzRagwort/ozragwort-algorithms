package com.ozragwort.code.baekjoon;

import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class q14562 {

    Queue<Integer[]> queue = new LinkedList<>();

    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int C = Integer.parseInt(br.readLine());

        for (int c = 0 ; c < C ; c++) {
            StringTokenizer stk = new StringTokenizer(br.readLine());
            int S = Integer.parseInt(stk.nextToken());
            int T = Integer.parseInt(stk.nextToken());

            queue.offer(new Integer[]{S, T, 0});
            while (!queue.isEmpty()) {
                Integer[] data = queue.poll();
                if (data[0].equals(data[1])) {
                    bw.write(data[2] + "\n");
                    queue.clear();
                    break;
                } else {
                    bfs(data[0], data[1], data[2]);
                }
            }
        }

        bw.flush();
        bw.close();
        br.close();
    }

    public void bfs(int s, int t, int count) {
        queue.offer(new Integer[]{s + 1, t, count + 1});
        if (s * 2 <= t + 3) {
            queue.offer(new Integer[]{s * 2, t + 3, count + 1});
        }
    }
}

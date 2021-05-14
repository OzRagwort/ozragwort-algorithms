package com.ozragwort.code.baekjoon;

import java.io.*;
import java.util.*;

public class q7569 {

    Queue<Integer[]> queue = new LinkedList<>();
    boolean[][][] box;
    int[][][] day;
    int M, N, H, x, y, z, counter = 0, remind = 0;
    int[] dm = {-1, 1, 0, 0, 0, 0};
    int[] dn = {0, 0, -1, 1, 0, 0};
    int[] dh = {0, 0, 0, 0, -1, 1};

    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stk = new StringTokenizer(br.readLine());
        N = Integer.parseInt(stk.nextToken());
        M = Integer.parseInt(stk.nextToken());
        H = Integer.parseInt(stk.nextToken());

        box = new boolean[M][N][H];
        day = new int[M][N][H];

        for (int h = 0 ; h < H ; h++) {
            for (int m = 0 ; m < M ; m++) {
                stk = new StringTokenizer(br.readLine());
                for (int n = 0 ; n < N ; n++) {
                    String num = stk.nextToken();
                    if (num.equals("1")) {
                        queue.offer(new Integer[]{m, n, h});
                    } else if (num.equals("0")) {
                        box[m][n][h] = true;
                        remind++;
                    }
                }
            }
        }

        while (!queue.isEmpty()) {
            Integer[] num = queue.poll();
            bfs(num[0], num[1], num[2]);
        }

        System.out.print(remind == 0 ? counter : -1);
    }

    public void bfs(int m, int n, int h) {

        for (int i = 0 ; i < 6 ; i++) {
            x = m + dm[i];
            y = n + dn[i];
            z = h + dh[i];

            if (0 <= x && x < M && 0 <= y && y < N && 0 <= z && z < H) {
                if (box[x][y][z]) {
                    box[x][y][z] = false;
                    queue.offer(new Integer[]{x, y, z});
                    day[x][y][z] = day[m][n][h] + 1;
                    remind--;
                    counter = Math.max(counter, day[x][y][z]);
                }
            }
        }
    }
}

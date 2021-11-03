package com.ozragwort.code.baekjoon;

import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class q3184 {

    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer stk = new StringTokenizer(br.readLine());
        int R = Integer.parseInt(stk.nextToken());
        int C = Integer.parseInt(stk.nextToken());
        char[][] table = new char[R][C];
        boolean[][] visit = new boolean[R][C];

        for (int i = 0 ; i < R ; i++) {
            String line = br.readLine();
            for (int j = 0 ; j < C ; j++) {
                table[i][j] = line.charAt(j);
                if (table[i][j] == '#') {
                    visit[i][j] = true;
                }
            }
        }

        Queue<int[]> queue = new LinkedList<>();
        int[] di = new int[]{1, -1, 0, 0};
        int[] dj = new int[]{0, 0, 1, -1};
        int sheep = 0;
        int wolf = 0;

        for (int i = 0 ; i < R ; i++) {
            for (int j = 0 ; j < C ; j++) {
                if (!visit[i][j] && table[i][j] != '#') {
                    queue.offer(new int[]{i, j});
                    visit[i][j] = true;
                    int s = 0, w = 0;

                    while (!queue.isEmpty()) {
                        int[] p = queue.poll();
                        if (table[p[0]][p[1]] == 'o') {
                            s++;
                        } else if (table[p[0]][p[1]] == 'v') {
                            w++;
                        }
                        table[p[0]][p[1]] = '#';

                        for (int d = 0 ; d < 4 ; d++) {
                            int ni = p[0] + di[d];
                            int nj = p[1] + dj[d];

                            if (0 <= ni && ni < R && 0 <= nj && nj < C && !visit[ni][nj] && table[ni][nj] != '#') {
                                queue.offer(new int[]{ni, nj});
                                visit[ni][nj] = true;
                            }
                        }
                    }

                    if (s <= w) {
                        wolf += w;
                    } else {
                        sheep += s;
                    }
                }
            }
        }

        System.out.print(sheep + " " + wolf);

        bw.flush();
        bw.close();
        br.close();
    }

}

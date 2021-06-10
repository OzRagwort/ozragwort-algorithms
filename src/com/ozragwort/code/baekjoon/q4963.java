package com.ozragwort.code.baekjoon;

import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class q4963 {

    Queue<Integer[]> queue = new LinkedList<>();
    int w, h;
    boolean[][] map;
    int[] dx = new int[]{1, -1, 0, 0, -1, -1, 1, 1};
    int[] dy = new int[]{0, 0, 1, -1, -1, 1, -1, 1};

    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        while (true) {
            StringTokenizer stk = new StringTokenizer(br.readLine());
            w = Integer.parseInt(stk.nextToken());
            h = Integer.parseInt(stk.nextToken());

            if (w == 0 && h == 0) {
                break;
            } else {
                map = new boolean[w + 1][h + 1];
                int counter = 0;

                // i = h, j = w
                for (int i = 1 ; i <= h ; i++) {
                    stk = new StringTokenizer(br.readLine());
                    for (int j = 1 ; j <= w ; j++) {
                        map[j][i] = stk.nextToken().equals("1");
                    }
                }

//                dfs
                for (int i = 1 ; i <= w ; i++) {
                    for (int j = 1 ; j <= h ; j++) {
                        if (map[i][j]) {
                            map[i][j] = false;
                            dfs(i, j);
                            counter++;
                        }
                    }
                }

//                bfs
//                // i = w->x, j = h->y
//                for (int i = 1 ; i <= w ; i++) {
//                    for (int j = 1 ; j <= h ; j++) {
//                        if (map[i][j]) {
//                            queue.offer(new Integer[]{i, j});
//                            map[i][j] = false;
//                            while (!queue.isEmpty()) {
//                                Integer[] position = queue.poll();
//                                bfs(position[0], position[1]);
//                            }
//                            counter++;
//                        }
//                    }
//                }

                bw.write(counter + "\n");
            }
        }

        bw.flush();
        bw.close();
        br.close();
    }

    public void dfs(int X, int Y) {
        for (int i = 0 ; i < 8 ; i++) {
            int x = X + dx[i];
            int y = Y + dy[i];

            if (1 <= x && x <= w && 1 <= y && y <= h) {
                if (map[x][y]) {
                    map[x][y] = false;
                    dfs(x, y);
                }
            }
        }
    }

    public void bfs(int X, int Y) {
        for (int i = 0 ; i < 8 ; i++) {
            int x = X + dx[i];
            int y = Y + dy[i];

            if (1 <= x && x <= w && 1 <= y && y <= h) {
                if (map[x][y]) {
                    queue.offer(new Integer[]{x, y});
                    map[x][y] = false;
                }
            }
        }
    }
}

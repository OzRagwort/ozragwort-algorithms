package com.ozragwort.code.programmers.level2;

import java.util.LinkedList;
import java.util.Queue;

public class q1829 {
    public int[] solution(int m, int n, int[][] picture) {
        int numberOfArea = 0;
        int maxSizeOfOneArea = 0;

        Queue<int[]> queue = new LinkedList<>();
        int[] di = new int[]{1, -1, 0, 0};
        int[] dj = new int[]{0, 0, 1, -1};
        int lenI = picture.length;
        int lenJ = picture[0].length;
        int[][] pic = new int[lenI][lenJ];
        boolean[][] visit = new boolean[lenI][lenJ];

        for (int i = 0 ; i < lenI ; i++) {
            System.arraycopy(picture[i], 0, pic[i], 0, lenJ);
        }

        for (int i = 0 ; i < lenI ; i++) {
            for (int j = 0 ; j < lenJ ; j++) {
                if (pic[i][j] == 0 || visit[i][j]) {
                    continue;
                } else {
                    queue = new LinkedList<>();
                    queue.offer(new int[]{i, j});
                    int target = pic[i][j];
                    visit[i][j] = true;
                    int size = 0;

                    while (!queue.isEmpty()) {
                        int[] p = queue.poll();
                        for (int r = 0 ; r < 4 ; r++) {
                            int pi = p[0] + di[r];
                            int pj = p[1] + dj[r];
                            if (0 <= pi && pi < lenI && 0 <= pj && pj < lenJ) {
                                if (pic[pi][pj] == target) {
                                    pic[pi][pj] = 0;
                                    queue.offer(new int[]{pi, pj});
                                    size++;
                                }
                            }
                        }
                    }
                    if (maxSizeOfOneArea < size) {
                        maxSizeOfOneArea = size;
                    }
                }
                numberOfArea++;
            }
        }

        int[] answer = new int[2];
        answer[0] = numberOfArea;
        answer[1] = maxSizeOfOneArea;
        return answer;
    }
}

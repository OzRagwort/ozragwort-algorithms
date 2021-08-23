package com.ozragwort.code.programmers.level2;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class q77485 {
    public int[] solution(int rows, int columns, int[][] queries) {
        int[][] table = new int[rows + 1][columns + 1];
        int[] dr = new int[]{1, 0, -1, 0};
        int[] dc = new int[]{0, 1, 0, -1};
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        List<Integer> list = new ArrayList<>();
        int num = 1;

        for (int r = 1 ; r <= rows ; r++) {
            for (int c = 1 ; c <= columns ; c++) {
                table[r][c] = num;
                num++;
            }
        }

        for (int[] query : queries) {
            int r1 = query[0];
            int c1 = query[1];
            int r2 = query[2];
            int c2 = query[3];
            int s = table[r1][c1];
            int r = r1;
            int c = c1;
            int i = 0;

            while (r != r1 || c != c1 + 1) {
                int nr = r + dr[i];
                int nc = c + dc[i];

                if (nr < r1 || nr > r2 || nc < c1 || nc > c2) {
                    i++;
                }
                table[r][c] = table[r + dr[i]][c + dc[i]];
                pq.offer(table[r][c]);
                r += dr[i];
                c += dc[i];
            }
            table[r][c] = s;
            pq.offer(s);

            list.add(pq.poll());
            pq.clear();
        }

        int[] answer = new int[list.size()];
        for (int i = 0 ; i < list.size() ; i++) {
            answer[i] = list.get(i);
        }
        return answer;
    }
}

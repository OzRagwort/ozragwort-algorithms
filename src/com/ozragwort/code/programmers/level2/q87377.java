package com.ozragwort.code.programmers.level2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class q87377 {
    public String[] solution(int[][] line) {
        List<long[]> list = new ArrayList<>();
        long minX = Long.MAX_VALUE;
        long minY = Long.MAX_VALUE;
        long maxX = Long.MIN_VALUE;
        long maxY = Long.MIN_VALUE;

        for (int i = 0 ; i < line.length - 1 ; i++) {
            for (int j = i + 1 ; j < line.length ; j++) {
                long[] meet = getMeet(line[i], line[j]);
                if (meet != null) {
                    minX = Math.min(minX, meet[0]);
                    minY = Math.min(minY, meet[1]);
                    maxX = Math.max(maxX, meet[0]);
                    maxY = Math.max(maxY, meet[1]);
                    list.add(meet);
                }
            }
        }

        String[] answer = new String[(int) (maxY - minY + 1)];
        char[][] chars = new char[(int) (maxY - minY + 1)][(int) (maxX - minX + 1)];
        for (int i = 0 ; i < chars.length ; i++) {
            Arrays.fill(chars[i], '.');
        }
        for (long[] l : list) {
            chars[(int) (maxY - l[1])][(int) (l[0] - minX)] = '*';
        }
        for (int i = 0 ; i < chars.length ; i++) {
            answer[i] = new String(chars[i]);
        }

        return answer;
    }

    public long[] getMeet(int[] a, int[] b) {
        if ((long) a[0] * b[1] == (long) a[1] * b[0]) {
            return null;
        } else {
            double x = ((double) a[1] * b[2] - (double) a[2] * b[1]) / ((double) a[0] * b[1] - (double) a[1] * b[0]);
            double y = ((double) a[2] * b[0] - (double) a[0] * b[2]) / ((double) a[0] * b[1] - (double) a[1] * b[0]);

            if (x % 1 == 0 && y % 1 == 0) {
                return new long[]{(long) x, (long) y};
            } else {
                return null;
            }
        }
    }
}

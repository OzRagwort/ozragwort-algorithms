package com.ozragwort.code.programmers.level3;

public class q43105 {
    public int solution(int[][] triangle) {
        int max = 0;
        int size = triangle.length;

        for (int i = 1 ; i < size ; i++) {
            triangle[i][0] += triangle[i - 1][0];

            for (int j = 1 ; j < i ; j++) {
                triangle[i][j] += Math.max(triangle[i - 1][j - 1], triangle[i - 1][j]);
            }

            triangle[i][i] += triangle[i - 1][i - 1];
        }

        for (int i = 0 ; i < size ; i++) {
            if (max < triangle[size - 1][i]) {
                max = triangle[size - 1][i];
            }
        }

        return max;
    }
}

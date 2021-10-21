package com.ozragwort.code.programmers.level1;

public class q86491 {
    public int solution(int[][] sizes) {
        int x = 0;
        int y = 0;

        for (int[] size : sizes) {
            int a = Math.max(size[0], size[1]);
            int b = Math.min(size[0], size[1]);

            x = Math.max(x, a);
            y = Math.max(y, b);
        }

        int answer = x * y;
        return answer;
    }
}

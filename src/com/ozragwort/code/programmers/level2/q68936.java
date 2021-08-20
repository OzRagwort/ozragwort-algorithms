package com.ozragwort.code.programmers.level2;

public class q68936 {
    int[] answer = new int[2];

    public int[] solution(int[][] arr) {
        quadtree(arr, 0, 0, arr.length);
        return answer;
    }

    public void quadtree(int[][] arr, int x, int y, int l) {
        int t = arr[x][y];
        for (int i = x ; i < x + l ; i++) {
            for (int j = y ; j < y + l ; j++) {
                if (t != arr[i][j]) {
                    l = l / 2;
                    quadtree(arr, x, y, l);
                    quadtree(arr, x + l, y, l);
                    quadtree(arr, x, y + l, l);
                    quadtree(arr, x + l, y + l, l);
                    return;
                }
            }
        }
        answer[t]++;
    }
}

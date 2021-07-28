package com.ozragwort.code.programmers.level3;

import java.util.Arrays;

class Solution {
    public int solution(int[] a) {
        int[][] min = new int[a.length][2];

        // 기준에서 왼쪽(작은 수)에 최소값 설정
        min[0][0] = a[0];
        for (int i = 1 ; i < a.length ; i++) {
            min[i][0] = Math.min(a[i], min[i - 1][0]);
        }

        // 기준에서 오른쪽(큰 수)에 최소값 설정
        min[a.length - 1][1] = a[a.length - 1];
        for (int i = a.length - 2 ; i >= 0 ; i--) {
            min[i][1] = Math.min(a[i], min[i + 1][1]);
        }

        // 가능한 값 개수 확인
        int answer = 2;
        for (int i = 1 ; i < a.length - 1 ; i++) {
            if (possible(min, a[i], i)) {
                answer++;
            }
        }
        return answer;
    }

    // 가능한지 판단(a = 판단할 수)
    public boolean possible(int[][] min, int a, int i) {
        // 0에서 a까지 또는 a에서 끝까지 중 한곳이라도 a가 가장 작은 수일 경우 가능함
        return a <= min[i - 1][0] || a <= min[i + 1][1];
    }
}
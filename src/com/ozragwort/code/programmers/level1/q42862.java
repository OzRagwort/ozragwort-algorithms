package com.ozragwort.code.programmers.level1;

public class q42862 {
    public int solution(int n, int[] lost, int[] reserve) {
        int answer = n;

        int[] check = new int[n + 2];

        for (int l : lost) {
            check[l]--;
        }

        for (int r : reserve) {
            check[r]++;
        }

        for (int i = 1 ; i <= n ; i++) {
            if (check[i] < 0 && check[i + 1] <= 0) {
                answer--;
            } else if (check[i] * check[i + 1] < 0) {
                check[i] = 0;
                check[i + 1] = 0;
            }
        }

        return answer;
    }
}

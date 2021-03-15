package com.ozragwort.code.baekjoon;

import java.util.Scanner;

public class q2775 {
    public void solution() {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[][] arr = new int[15][15];

        for (int i = 0 ; i <= 14 ; i++) {
            for (int j = 0 ; j <= 14 ; j++) {
                if (i == 0)
                    arr[i][j] = j+1;
                else {
                    for (int k = j ; k >= 0 ; k--) {
                        arr[i][j] += arr[i-1][k];
                    }
                }
            }
        }

        while(N > 0) {
            int k = sc.nextInt();
            int n = sc.nextInt();
            System.out.println(arr[k][n-1]);
            N--;
        }

    }
}

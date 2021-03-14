package com.ozragwort.code.baekjoon;

import java.util.Scanner;

public class q4344 {
    public void solution() {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();

        for (int i = 0 ; i < N ; i++) {
            int n = sc.nextInt();
            int[] arr = new int[n];
            double avr = 0;
            int upCount = 0;
            for (int j = 0 ; j < n ; j++) {
                arr[j] = sc.nextInt();
                avr += arr[j];
            }
            avr = avr / (double) n;
            for (int j = 0 ; j < n ; j++) {
                if (avr < arr[j])
                    upCount++;
            }
            System.out.println(String.format("%.3f", ((double) upCount / (double) n * 100)) + "%");
        }
    }
}

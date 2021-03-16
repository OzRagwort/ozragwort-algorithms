package com.ozragwort.code.baekjoon;

import java.util.Scanner;

public class q11653 {
    public void solution() {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int i = 2;
        while(N > 1) {
            if (N % i == 0) {
                System.out.println(i);
                N /= i;
            } else {
                i++;
            }
        }
    }
}

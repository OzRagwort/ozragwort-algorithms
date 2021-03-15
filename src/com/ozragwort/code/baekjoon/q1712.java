package com.ozragwort.code.baekjoon;

import java.util.Scanner;

public class q1712 {
    public void solution() {
        Scanner sc = new Scanner(System.in);
        int A = sc.nextInt();
        int B = sc.nextInt();
        int C = sc.nextInt();
        int counter = -1;

        if (B < C) {
            counter++;
            while(A >= 0) {
                A -= (C - B);
                counter++;
            }
        }
        System.out.println(counter);
    }
}

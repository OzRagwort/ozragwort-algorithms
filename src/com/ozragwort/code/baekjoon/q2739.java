package com.ozragwort.code.baekjoon;

import java.util.Scanner;

public class q2739 {
    public void solution() {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();

        for(int i = 1 ; i <= 9 ; i++) {
            System.out.println(a + " * " + i + " = " + a*i);
        }
    }
}

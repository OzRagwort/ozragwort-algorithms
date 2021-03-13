package com.ozragwort.code.baekjoon;

import java.util.Scanner;

public class q10952 {
    public void solution() {
        Scanner sc = new Scanner(System.in);

        while(true) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            if (a+b == 0) {
                break;
            } else {
                System.out.println(a+b);
            }
        }
    }
}

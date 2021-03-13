package com.ozragwort.code.baekjoon;

import java.util.Scanner;

public class q10950 {
    public void solution() {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();

        for (int i = 0 ; i < N ; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            System.out.println(a+b);
        }
    }
}

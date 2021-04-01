package com.ozragwort.code.baekjoon;

import java.util.Scanner;

public class q10430 {
    public void solution() {
        Scanner sc = new Scanner(System.in);

        int a, b, c;

        a = sc.nextInt();
        b = sc.nextInt();
        c = sc.nextInt();

        System.out.println((a + b) % c);
        System.out.println(((a % c) + (b % c)) % c);
        System.out.println((a * b) % c);
        System.out.println((a % c) * (b % c) % c);
    }
}

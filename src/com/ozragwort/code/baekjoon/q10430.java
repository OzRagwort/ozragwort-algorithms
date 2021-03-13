package com.ozragwort.code.baekjoon;

import java.util.Scanner;

public class q10430 {
    public void solution() {
        Scanner sc = new Scanner(System.in);

        int a, b, c;

        a = sc.nextInt();
        b = sc.nextInt();
        c = sc.nextInt();

        if(2 <= a && 2 <= b && 2 <= c && a <=10000 && b <=10000 && c <=10000)
        {
            System.out.println((a + b) % c);
            System.out.println(((a % c) + (b % c)) % c);
            System.out.println((a * b) % c);
            System.out.println((a % c) * (b % c) % c);
        }
        else
            System.out.println("error");
    }
}

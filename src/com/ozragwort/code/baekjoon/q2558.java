package com.ozragwort.code.baekjoon;

import java.util.Scanner;

public class q2558 {
    public void solution() {
        Scanner sc = new Scanner(System.in);

        int a, b;

        a = sc.nextInt();
        b = sc.nextInt();

        if(0 < a && 0 < b && a < 10 && b < 10)
            System.out.println(a + b);
        else
            System.out.println("error");
    }
}

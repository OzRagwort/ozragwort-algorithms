package com.ozragwort.code.baekjoon;

import java.util.Scanner;

public class q2588 {
    public void solution() {
        Scanner sc = new Scanner(System.in);
        int a, b, c, d, e, f;
        a = sc.nextInt();
        b = sc.nextInt();

        c = a*(b%10);
        b /= 10;
        d = a*(b%10);
        b /= 10;
        e = a*(b%10);
        f = c + d*10 + e * 100;
        System.out.println(c);
        System.out.println(d);
        System.out.println(e);
        System.out.println(f);
    }
}

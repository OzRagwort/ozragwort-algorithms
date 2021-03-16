package com.ozragwort.code.baekjoon;

import java.util.Scanner;

public class q1085 {
    public void solution() {
        Scanner sc = new Scanner(System.in);
        int x = sc.nextInt();
        int y = sc.nextInt();
        int w = sc.nextInt();
        int h = sc.nextInt();
        System.out.println(Math.min(Math.min(x, (w - x)), Math.min(y, (h - y))));
    }
}

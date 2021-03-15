package com.ozragwort.code.baekjoon;

import java.util.Scanner;

public class q2869 {
    public void solution() {
        Scanner sc = new Scanner(System.in);
        int A = sc.nextInt();
        int B = sc.nextInt();
        int V = sc.nextInt() - B;
        int counter;

        counter = (int) Math.ceil((double) V / (double) (A - B));

        System.out.println(counter);
    }
}

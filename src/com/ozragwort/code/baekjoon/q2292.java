package com.ozragwort.code.baekjoon;

import java.util.Scanner;

public class q2292 {
    public void solution() {
        Scanner sc = new Scanner(System.in);
        int A = sc.nextInt() - 1;
        int counter = 1;
        int divCount = 0;

        while(A > 0) {
            divCount++;
            A -= divCount * 6;
            counter++;
        }

        System.out.println(counter);
    }
}

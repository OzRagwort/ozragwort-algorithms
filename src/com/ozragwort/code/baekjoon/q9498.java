package com.ozragwort.code.baekjoon;

import java.util.Scanner;

public class q9498 {
    public void solution() {
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();

        if (num < 60) {
            System.out.print("F");
        } else if (num < 70) {
            System.out.print("D");
        } else if (num < 80) {
            System.out.print("C");
        } else if (num < 90) {
            System.out.print("B");
        } else {
            System.out.print("A");
        }
    }
}

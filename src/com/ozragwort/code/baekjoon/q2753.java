package com.ozragwort.code.baekjoon;

import java.util.Scanner;

public class q2753 {
    public void solution() {
        Scanner sc = new Scanner(System.in);
        int year = sc.nextInt();

        boolean check = (year % 4 == 0 && year % 100 != 0) || year % 400 == 0;
        System.out.print(check ? "1" : "0");
    }
}

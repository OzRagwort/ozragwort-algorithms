package com.ozragwort.code.baekjoon;

import java.util.Scanner;

public class q1330 {
    public void solution() {
        Scanner sc = new Scanner(System.in);
        int a, b;
        a = sc.nextInt();
        b = sc.nextInt();

        if (a > b) {
            System.out.println(">");
        } else if (a < b) {
            System.out.println("<");
        } else {
            System.out.println("==");
        }
//        삼항 연산자
//        String ret = a > b ? ">" : (a < b ? "<" : "==");
//        System.out.print(ret);
    }
}

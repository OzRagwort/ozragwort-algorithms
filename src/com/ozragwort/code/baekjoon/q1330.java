package com.ozragwort.code.baekjoon;

import java.util.Scanner;

public class q1330 {
    public void solution() {
        Scanner sc = new Scanner(System.in);
        int a, b;
        a = sc.nextInt();
        b = sc.nextInt();

        if ((a >= -10000 && a <= 10000) && (b >= -10000 && b <= 10000)) {
            String ret = a > b ? ">" : (a < b ? "<" : "==");
            System.out.print(ret);
        }
    }
}

package com.ozragwort.code.baekjoon;

import java.util.Scanner;

public class q8393 {
    public void solution() {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int result = 0;

        for (int i = 1 ; i <= N ; i++) {
            result += i;
        }
        System.out.println(result);
    }
}

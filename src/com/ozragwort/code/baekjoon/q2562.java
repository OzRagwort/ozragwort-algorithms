package com.ozragwort.code.baekjoon;

import java.util.Scanner;

public class q2562 {
    public void solution() {
        Scanner sc = new Scanner(System.in);
        int max = 0;
        int index = 0;

        for (int i = 1 ; i <= 9 ; i++) {
            int a = sc.nextInt();
            if (max < a) {
                max = a;
                index = i;
            }
        }
        System.out.println(max);
        System.out.println(index);
    }
}

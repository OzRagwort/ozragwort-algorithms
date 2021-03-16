package com.ozragwort.code.baekjoon;

import java.util.Scanner;

public class q2581 {
    public void solution() {
        Scanner sc = new Scanner(System.in);
        int M = sc.nextInt();
        int N = sc.nextInt();
        int sum = 0, min = 0;

        for (int i = M ; i <= N ; i++) {
            if (check(i)) {
                if (min == 0)
                    min = i;
                sum += i;
            }
        }
        if (sum != 0) {
            System.out.println(sum);
            System.out.println(min);
        } else {
            System.out.println("-1");
        }
    }

    public boolean check(int i) {
        if (i == 1)
            return false;
        else {
            for (int j = 2 ; j <= Math.sqrt(i) ; j++) {
                if (i % j == 0) {
                    return false;
                }
            }
        }
        return true;
    }
}

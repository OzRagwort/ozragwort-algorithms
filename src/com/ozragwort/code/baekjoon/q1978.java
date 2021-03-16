package com.ozragwort.code.baekjoon;

import java.util.Scanner;

public class q1978 {
    public void solution() {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int counter = 0;

        for (int i = 0 ; i < N ; i++) {
            int n = sc.nextInt();
            if (n != 1) {
                counter++;
                for (int j = 2 ; j <= Math.sqrt(n) ; j++) {
                    if (n % j == 0) {
                        counter--;
                        break;
                    }
                }
            }
        }
        System.out.println(counter);
    }
}

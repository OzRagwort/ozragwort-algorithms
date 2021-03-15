package com.ozragwort.code.baekjoon;

import java.util.Scanner;

public class q1193 {
    public void solution() {
        Scanner sc = new Scanner(System.in);
        int X = sc.nextInt() - 1;
        int x = 1, y = 1;

        while(X > 0) {
            if ((x + y) % 2 == 0) {
                x++;
                y = y == 1 ? y : y-1;
            } else {
                x = x == 1 ? x : x-1;
                y++;
            }
            X--;
        }

        System.out.println(y + "/" + x);
    }
}

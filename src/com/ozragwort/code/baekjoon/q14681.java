package com.ozragwort.code.baekjoon;

import java.util.Scanner;

public class q14681 {
    public void solution() {
        Scanner sc = new Scanner(System.in);
        int x = sc.nextInt();
        int y = sc.nextInt();

        if (x != 0 && y != 0 && ((x >= -1000 && x <= 1000) || y >= -1000 && y <= 1000)) {
            if (x > 0 && y > 0)
                System.out.println("1");
            if (x > 0 && y < 0)
                System.out.println("4");
            if (x < 0 && y > 0)
                System.out.println("2");
            if (x < 0 && y < 0)
                System.out.println("3");
        }
    }
}

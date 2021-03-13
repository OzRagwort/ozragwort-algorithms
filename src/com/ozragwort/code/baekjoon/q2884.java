package com.ozragwort.code.baekjoon;

import java.util.Scanner;

public class q2884 {
    public void solution() {
        Scanner sc = new Scanner(System.in);
        int h = sc.nextInt();
        int m = sc.nextInt();

        m -= 45;
        if (m < 0){
            if (h == 0)
                h += 24;
            h--;
            m += 60;
        }

        System.out.println(h + " " + m);
    }
}

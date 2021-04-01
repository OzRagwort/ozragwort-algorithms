package com.ozragwort.code.baekjoon;

import java.util.Scanner;

public class q2839 {
    public void solution() {
        Scanner sc = new Scanner(System.in);

        int a;

        a = sc.nextInt();

        int i;
        for(i = (a/5) ; i >= 0 ; i--) {
            int j = (a-(i*5))/3;
            if(a % ((i*5)+(j*3)) == 0)
            {
                System.out.println(i + j);
                break;
            }
        }
        if(i < 0)
            System.out.println("-1");
    }
}

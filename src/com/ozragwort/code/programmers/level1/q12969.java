package com.ozragwort.code.programmers.level1;

import java.util.Scanner;

public class q12969 {
    public void solution() {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();

        StringBuilder sb = new StringBuilder();

        for (int i = 0 ; i < b ; i++) {
            for (int j = 0 ; j < a ; j++) {
                sb.append("*");
            }
            sb.append("\n");
        }

        System.out.print(sb.toString());
    }
}

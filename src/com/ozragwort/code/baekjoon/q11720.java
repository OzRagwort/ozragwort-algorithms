package com.ozragwort.code.baekjoon;

import java.util.*;

public class q11720 {
    public void solution() {
        Scanner sc = new Scanner(System.in);
        int result = 0;
        int N = Integer.parseInt(sc.nextLine());
        String value = sc.nextLine();

        for (int i = 0 ; i < N ; i++) {
            result += Integer.parseInt(value.substring(i, i+1));
        }

        System.out.println(result);
    }
}

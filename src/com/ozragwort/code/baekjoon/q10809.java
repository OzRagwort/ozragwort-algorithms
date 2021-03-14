package com.ozragwort.code.baekjoon;

import java.util.*;

public class q10809 {
    public void solution() {
        Scanner sc = new Scanner(System.in);
        String value = sc.nextLine();

        for (int i = 97 ; i <= 122 ; i++) {
            System.out.print(value.indexOf((char) i) + " ");
        }
    }
}

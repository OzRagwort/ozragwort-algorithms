package com.ozragwort.code.baekjoon;

import java.util.Scanner;

public class q10250 {
    public void solution() {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();

        for (int i = 0 ; i < N ; i++) {
            int H = sc.nextInt();
            int W = sc.nextInt();
            int T = sc.nextInt();
            int counter = ((T % H) == 0 ? H : (T % H)) * 100 + (int) Math.ceil((double) T / (double) H);
            System.out.println(counter);
        }
    }
}
